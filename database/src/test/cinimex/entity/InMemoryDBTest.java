package cinimex.entity;

import cinimex.JPArepository.BalanceRepository;
import cinimex.conf.H2JpaConfig;
import cinimex.entity.BalanceEntity;
import lombok.experimental.ExtensionMethod;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(
        classes = { H2JpaConfig.class },
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class InMemoryDBTest {

    @Resource
    private BalanceRepository balanceRepository;

    @Test
    public void givenStudent_whenSave_thenGetOk() {
        BalanceEntity savedEntity = balanceRepository.save(new BalanceEntity());
    }
}
