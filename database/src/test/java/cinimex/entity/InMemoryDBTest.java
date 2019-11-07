package cinimex.entity;

import cinimex.H2JpaConfig;
import cinimex.JPArepository.BalanceRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;

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
