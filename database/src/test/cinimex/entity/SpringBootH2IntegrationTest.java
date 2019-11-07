package cinimex.entity;

import cinimex.conf.H2JpaConfig;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { H2JpaConfig.class})
public class SpringBootH2IntegrationTest {
    // ...
}

