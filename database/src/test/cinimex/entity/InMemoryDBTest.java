package cinimex.entity;

import cinimex.JPArepository.BalanceRepository;
import cinimex.conf.H2JpaConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = { H2JpaConfig.class },
        loader = AnnotationConfigContextLoader.class)
public class InMemoryDBTest {

    @Resource
    private BalanceRepository balanceRepository;

    @Test
    public void givenStudent_whenSave_thenGetOk() {
        System.out.println("lol blyat");
        BalanceEntity savedEntity = balanceRepository.save(new BalanceEntity());
    }
}
