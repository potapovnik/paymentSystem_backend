package cinimex.services;

import cinimex.H2JpaConfig;
import cinimex.JPArepository.BalanceRepository;
import cinimex.JPArepository.JournalRepository;
import cinimex.JPArepository.TransferRepository;
import cinimex.config.TestConfig;
import cinimex.entity.BalanceEntity;
import cinimex.entity.JournalEntity;
import cinimex.entity.TransferEntity;
import cinimex.mapper.JournalMapper;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = {H2JpaConfig.class, TransferService.class, TestConfig.class},
        loader = AnnotationConfigContextLoader.class)
class TransferServiceTest {
    @Resource
    private BalanceRepository balanceRepository;
    @Resource
    private TransferRepository transferRepository;
    @Resource
    private TransferService transferService;
    @Resource
    private JournalRepository journalRepository;

    @Autowired
    JournalMapper journalMapper;

    @Test
    void testIsLock() {
        BalanceEntity newBalance = new BalanceEntity();
        String numberOfBalance = "1234567890";
        newBalance.setNumberOfBalance(numberOfBalance);
        newBalance.setLock(true);
        balanceRepository.save(newBalance);
        assertEquals(transferService.isLock(numberOfBalance), true);
        newBalance.setLock(false);
        balanceRepository.save(newBalance);
        assertEquals(transferService.isLock(numberOfBalance), false);
    }

    @Test
    void testReturnCorrectIdNumber() {
        BalanceEntity balanceEntity = new BalanceEntity();
        balanceEntity.setNumberOfBalance("123123");
        Long id = balanceRepository.save(balanceEntity).getId();
        assertNotNull(transferService.returnCorrectIdNumber(id));
        assertNull(transferService.returnCorrectIdNumber(null));
    }

    @Test
    void testSaveTransfer() {
        BalanceEntity firstBalance = balanceRepository.save(new BalanceEntity());
        BalanceEntity secondBalance = balanceRepository.save(new BalanceEntity());
        Long transferId = transferService.saveTransfer(firstBalance, null);
        assertNotNull(transferRepository.findById(transferId).get().getFromBalanceId());
        assertNull(transferRepository.findById(transferId).get().getToBalanceId());

        transferId = transferService.saveTransfer(null, secondBalance);
        assertNull(transferRepository.findById(transferId).get().getFromBalanceId());
        assertNotNull(transferRepository.findById(transferId).get().getToBalanceId());

        transferId = transferService.saveTransfer(firstBalance, secondBalance);
        assertNotNull(transferRepository.findById(transferId).get().getFromBalanceId());
        assertNotNull(transferRepository.findById(transferId).get().getToBalanceId());
    }

    @Test
    void saveJournal() {
        JournalEntity journal = journalRepository.save(new JournalEntity());
        Long idTransfer = transferRepository.save(new TransferEntity()).getId();
        boolean resultOfMethod = transferService.saveJournal(idTransfer,journal);
        boolean resultOfSearch =  transferRepository.findById(journal.getId())==null?false:true;
        assertEquals(resultOfMethod,resultOfSearch);
        JournalEntity savedJournal = journalRepository.findById(journal.getId()).get();
        assertNotNull(savedJournal.getTime());
    }
}