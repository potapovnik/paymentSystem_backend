package cinimex.conf;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("cinimex.entity")
@EnableJpaRepositories("cinimex.JPArepository")
public class Config {
}
