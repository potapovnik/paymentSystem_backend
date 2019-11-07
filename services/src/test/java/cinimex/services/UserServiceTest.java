package cinimex.services;

import cinimex.DTO.UserDto;
import cinimex.H2JpaConfig;
import cinimex.JPArepository.UserRepository;
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
        classes = {H2JpaConfig.class},
        loader = AnnotationConfigContextLoader.class)
class UserServiceTest {
    @Resource
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        UsersEntity newUser = new UsersEntity();
        newUser.setDateRegistration(new Timestamp(System.currentTimeMillis()));
        newUser.setId(null);
        UsersEntity savedUser = userRepository.save(newUser);
        assertNotNull(savedUser.getId());
        assertNotNull(savedUser.getDateRegistration());
    }

    @Test
    public void testDeleteUser() {
        UsersEntity newUser = new UsersEntity();
        newUser.setId(100L);
        Long id = userRepository.save(newUser).getId();
        userRepository.deleteById(id);
        assertEquals(userRepository.findById(id).isPresent(), false);

    }
    @Test
    public void findUserByLogin() {
        UsersEntity newUser = new UsersEntity();
        String login = "test";
        newUser.setLogin(login);
        userRepository.save(newUser);
        assertNotNull(userRepository.findByLogin(login));

    }


}