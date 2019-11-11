package cinimex.services;

import cinimex.DTO.RoleDto;
import cinimex.DTO.UserDto;
import cinimex.JPArepository.*;
import cinimex.entity.RoleEntity;
import cinimex.entity.UsersEntity;
import cinimex.exceptions.LogicException;
import cinimex.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BalanceService balanceService;
    private final RoleRepository roleRepository;

    @Transactional
    public UserDto createUser(UserDto newUserDto) {
        if (newUserDto == null)
            throw new LogicException("dto для создания юзера Null");
        UsersEntity newUser = userMapper.fromDto(newUserDto);
        newUser.setDateRegistration(new Timestamp(System.currentTimeMillis()));
        newUser.setId(null);
        UsersEntity savedUser = userRepository.save(newUser);
        balanceService.balanceForNewUser(savedUser.getId());
        return userMapper.toDto(savedUser);
    }

    public boolean deleteUser(Long id) {
        if (userRepository.findById(id).isPresent())
            throw new LogicException("(попытка удаления) - юзера с данным id=" + id.toString() + " не существует");
        userRepository.deleteById(id);
        return true;

    }

    public UserDto updateUser(UserDto updateUserDto) {
        if (updateUserDto == null)
            throw new LogicException("dto для обовления данных юзера Null");
        UsersEntity updateUser = userMapper.fromDto(updateUserDto);
        if (updateUserDto.getPassword() == null) {
            String currentPassword = userRepository.findById(updateUserDto.getId()).get().getPassword();
            updateUser.setPasswordWithoutEncode(currentPassword);
        }
        UsersEntity updatedUser = userRepository.save(updateUser);
        return userMapper.toDto(updatedUser);
    }

    public RoleDto getRoleOfUser(Long id) {
        UsersEntity user = userRepository.findById(id).get();
        RoleEntity role = roleRepository.findById(user.getRoleId()).get();
        RoleDto newRoleDto = new RoleDto();
        newRoleDto.setId(role.getId());
        newRoleDto.setName(role.getRole().name());
        return newRoleDto;
    }

    public List<UserDto> getAllUser() {
        List<UsersEntity> allUsers = userRepository.findAll();
        return userMapper.toDto(allUsers);
    }

    public UserDto findUserByLogin(String login) {
        return userMapper.toDto(userRepository.findByLogin(login));
    }

}
