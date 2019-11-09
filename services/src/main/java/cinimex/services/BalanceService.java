package cinimex.services;

import cinimex.DTO.BalanceDto;
import cinimex.DTO.TransferDto;
import cinimex.JPArepository.BalanceRepository;
import cinimex.JPArepository.JournalRepository;
import cinimex.JPArepository.TransferRepository;
import cinimex.entity.BalanceEntity;
import cinimex.entity.JournalEntity;
import cinimex.entity.TransferEntity;
import cinimex.exceptions.LogicException;
import cinimex.mapper.BalanceMapper;
import cinimex.mapper.JournalMapper;
import cinimex.utils.NumberGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class BalanceService {
    private final BalanceRepository balanceRepository;
    private final BalanceMapper balanceMapper;

    public Boolean lockBalance(Long id, Boolean isLock) {
        if (isLock == null){
            throw  new LogicException("Передано неверное значение isLock");
        }
        BalanceEntity balanceOnLock = balanceRepository.findByUserId(id);
        balanceOnLock.setLock(isLock);
        if (balanceRepository.save(balanceOnLock) == null)
            return false;
        return true;
    }

    public Boolean balanceForNewUser(Long id) {
        BalanceEntity newBalance = new BalanceEntity();
        newBalance.setMoney(0);
        String newNumberOfBalance = NumberGenerator.generateNumberOfBalance();
        while (!checkUniqueNumberOfBalance(newNumberOfBalance))
            newNumberOfBalance = NumberGenerator.generateNumberOfBalance();
        newBalance.setNumberOfBalance(newNumberOfBalance);
        newBalance.setLock(false);
        newBalance.setUserId(id);
        BalanceEntity createdBalance = balanceRepository.save(newBalance);
        if (createdBalance == null)
            return false;
        return true;
    }

    public BalanceDto getBalanceByIdUser(Long idUser)  {
        BalanceEntity balanceOfUser = balanceRepository.findByUserId(idUser);
        if (balanceOfUser == null)
            throw new LogicException("У юзера с id" + idUser + " не существует ни одного баланса");
        return balanceMapper.toDto(balanceOfUser);
    }

    public BalanceDto getBalance(Long id) {
        BalanceEntity balanceOfUser = balanceRepository.findById(id).get();
        if (balanceOfUser == null)
            throw new LogicException("баланса с id=" + id + " не существует");
        return balanceMapper.toDto(balanceOfUser);
    }

    public boolean checkUniqueNumberOfBalance(String numberOfBalance) {
        Long countOfCopy = balanceRepository.findAll().stream().filter(balanceEntity -> balanceEntity.getNumberOfBalance() == numberOfBalance).count();
        if (countOfCopy == 0)
            return true;
        return false;
    }

}
