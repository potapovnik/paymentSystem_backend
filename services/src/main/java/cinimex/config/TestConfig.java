package cinimex.config;

import cinimex.mapper.BalanceMapper;
import cinimex.mapper.JournalMapper;
import cinimex.mapper.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public JournalMapper journalMapper() {
        return Mappers.getMapper(JournalMapper.class);
    }

    @Bean
    public UserMapper userMapper() {
        return Mappers.getMapper(UserMapper.class);
    }
    @Bean
    public BalanceMapper balanceMapper() {
        return Mappers.getMapper(BalanceMapper.class);
    }
}