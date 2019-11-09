package cinimex.services;

import cinimex.H2JpaConfig;
import cinimex.JPArepository.BalanceRepository;
import cinimex.JPArepository.UserRepository;
import cinimex.config.TestConfig;
import cinimex.entity.BalanceEntity;
import cinimex.entity.UsersEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = {H2JpaConfig.class, BalanceService.class, TestConfig.class},
        loader = AnnotationConfigContextLoader.class)
class BalanceServiceTest {
    @Resource
    private BalanceService balanceService;
    @Resource
    private BalanceRepository balanceRepository;
    @Resource
    private UserRepository userRepository;
    @Test
    void testLockBalance() {
        BalanceEntity balance = balanceRepository.save(new BalanceEntity());
        UsersEntity user = userRepository.save(new UsersEntity());
        balance.setUserId(user.getId());
        balanceRepository.save(balance);
        balanceService.lockBalance(user.getId(), true);
        assertEquals(balanceRepository.findById(balance.getId()).get().isLock(), true);
        balanceService.lockBalance(user.getId(), false);
        assertEquals(balanceRepository.findById(balance.getId()).get().isLock(), false);
    }
    @Test
    void testBalanceForNewUser(){
        UsersEntity newUser = userRepository.save(new UsersEntity());
        balanceService.balanceForNewUser(newUser.getId());
        BalanceEntity savedBalance = balanceRepository.findByUserId(newUser.getId());
        assertNotNull(savedBalance.getNumberOfBalance());
        assertEquals(savedBalance.getMoney(),(Integer) 0);
        assertEquals(savedBalance.isLock(),false);
    }
}