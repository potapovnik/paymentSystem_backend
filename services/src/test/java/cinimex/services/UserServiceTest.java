package cinimex.services;

import cinimex.DTO.UserDto;
import cinimex.H2JpaConfig;
import cinimex.JPArepository.BalanceRepository;
import cinimex.JPArepository.UserRepository;
import cinimex.config.TestConfig;
import cinimex.entity.UsersEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;

import static org.junit.Assert.*;

import java.sql.Timestamp;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = {H2JpaConfig.class, TestConfig.class, UserService.class, BalanceService.class},
        loader = AnnotationConfigContextLoader.class)
class UserServiceTest {
    @Resource
    private UserRepository userRepository;
    @Resource
    private UserService userService;
    @Resource
    private BalanceRepository balanceRepository;


    @Test
    void testCreateUser() throws Exception {
        UserDto newUser = new UserDto();
        newUser.setPassword("password");
        UserDto savedUserDto = userService.createUser(newUser);
        assertNotNull(savedUserDto.getId());
        assertNotNull(savedUserDto.getDateRegistration());
        assertNotNull(balanceRepository.findByUserId(savedUserDto.getId()));
    }

    @Test
    void testDeleteUser() throws Exception {
        UsersEntity newUser = new UsersEntity();
        newUser.setId(100L);
        Long id = userRepository.save(newUser).getId();
        userService.deleteUser(id);
        assertEquals(userRepository.findById(id).isPresent(), false);

    }

    @Test
    void findUserByLogin() {
        UsersEntity newUser = new UsersEntity();
        String login = "test";
        newUser.setLogin(login);
        userRepository.save(newUser);
        assertNotNull(userRepository.findByLogin(login));
        assertNull(userRepository.findByLogin("notExistEntity"));
    }


}