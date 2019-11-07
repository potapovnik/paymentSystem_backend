package cinimex.services;

import cinimex.DTO.TransferDto;
import cinimex.JPArepository.BalanceRepository;
import cinimex.JPArepository.JournalRepository;
import cinimex.JPArepository.TransferRepository;
import cinimex.entity.BalanceEntity;
import cinimex.entity.JournalEntity;
import cinimex.entity.TransferEntity;
import cinimex.mapper.BalanceMapper;
import cinimex.mapper.JournalMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TransferService {
    private final BalanceRepository balanceRepository;
    private final TransferRepository transferRepository;
    private final JournalRepository journalRepository;
    private final JournalMapper journalMapper;

    @Transactional
    public boolean transferBalanceToBalance(TransferDto transferDto) {
        if (isLock(transferDto.getFromBalance()) || isLock(transferDto.getToBalance()))//если хотя бы один из балансов заблакирован,передача невозможна
            return false;
        BalanceEntity balanceFromOperation = balanceRepository.findByNumberOfBalance(transferDto.getFromBalance());
        int moneyOnBalance = balanceFromOperation.getMoney();
        JournalEntity journal = journalMapper.fromDto(transferDto.getJournal());
        if (moneyOnBalance < transferDto.getJournal().getMoney())
            return false;

        balanceFromOperation.setMoney(moneyOnBalance - journal.getMoney()); // вычитаем деньги которые ушли со счёта
        balanceRepository.save(balanceFromOperation);
        BalanceEntity balanceToOperation = balanceRepository.findByNumberOfBalance(transferDto.getToBalance());
        balanceToOperation.setMoney(balanceToOperation.getMoney() + journal.getMoney()); // добавляем пересланные деньги
        balanceRepository.save(balanceToOperation);

        TransferEntity currentTransfer = new TransferEntity();
        currentTransfer.setFromBalanceId(balanceFromOperation.getId());
        currentTransfer.setToBalanceId(balanceToOperation.getId());
        Long idCurrentTransfer = transferRepository.save(currentTransfer).getId();

        journal.setTime(new Timestamp(System.currentTimeMillis()));
        journal.setTransferId(idCurrentTransfer);
        journalRepository.save(journal);
        return true;
    }

    @Transactional
    public boolean transferOnCard(TransferDto transferDto) {
        if (isLock(transferDto.getFromBalance()))
            return false;
        BalanceEntity balanceFromOperation = balanceRepository.findByNumberOfBalance(transferDto.getFromBalance());
        int moneyOnBalance = balanceFromOperation.getMoney();
        JournalEntity journal = journalMapper.fromDto(transferDto.getJournal());
        if (moneyOnBalance < transferDto.getJournal().getMoney())
            return false;
        balanceFromOperation.setMoney(moneyOnBalance - journal.getMoney());
        balanceRepository.save(balanceFromOperation);

        TransferEntity currentTransfer = new TransferEntity();
        currentTransfer.setFromBalanceId(balanceFromOperation.getId());
        Long idCurrentTransfer = transferRepository.save(currentTransfer).getId();


        journal.setTime(new Timestamp(System.currentTimeMillis()));
        journal.setTransferId(idCurrentTransfer);
        journalRepository.save(journal);
        return true;
    }

    @Transactional
    public boolean transferOnBalance(TransferDto transferDto) {
        if (isLock(transferDto.getToBalance()))
            return false;

        BalanceEntity balanceToOperation = balanceRepository.findByNumberOfBalance(transferDto.getToBalance());
        JournalEntity journal = journalMapper.fromDto(transferDto.getJournal());
        balanceToOperation.setMoney(balanceToOperation.getMoney() + journal.getMoney());
        balanceRepository.save(balanceToOperation);


        TransferEntity currentTransfer = new TransferEntity();
        currentTransfer.setToBalanceId(balanceToOperation.getId());
        Long idCurrentTransfer = transferRepository.save(currentTransfer).getId();


        journal.setTime(new Timestamp(System.currentTimeMillis()));
        journal.setTransferId(idCurrentTransfer);
        journalRepository.save(journal);
        return true;
    }

    public List<TransferDto> allTransferAndJournalOfUser(Long id) throws Exception {
        Long idBalanceOfUser = balanceRepository.findByUserId(id).getId();
        List<TransferEntity> transfersOfUser = transferRepository.findByFromBalanceId(idBalanceOfUser);// найдём все переводы с баланса
        transfersOfUser.addAll(transferRepository.findByToBalanceId(idBalanceOfUser)); // найдём все перевода на баланс
        List<JournalEntity> journalOfUser = new ArrayList<>();
        transfersOfUser.stream().forEach(transferEntity -> journalOfUser.add(journalRepository.findByTransferId(transferEntity.getId()).get(0)));
        if (transfersOfUser.size() != journalOfUser.size())
            throw new Exception("Ошибка в соответсвии журнала и переводов в базе данных");

        List<TransferDto> transfers = new ArrayList<>();
        for (int i = 0; i < transfersOfUser.size(); i++) {
            TransferDto currentTransfer = new TransferDto();
            currentTransfer.setFromBalance(returnCorrectIdNumber(transfersOfUser.get(i).getFromBalanceId()));
            currentTransfer.setToBalance(returnCorrectIdNumber(transfersOfUser.get(i).getToBalanceId()));
            currentTransfer.setJournal(journalMapper.toDto(journalOfUser.get(i)));
            transfers.add(currentTransfer);
        }
        return transfers;
    }

    public boolean isLock(String numberOfBalance) {
        return balanceRepository.findByNumberOfBalance(numberOfBalance).isLock();
    }


    public String returnCorrectIdNumber(Long id) {
        if (id == null)
            return null;
        return balanceRepository.findById(id).get().getNumberOfBalance();
    }
}
