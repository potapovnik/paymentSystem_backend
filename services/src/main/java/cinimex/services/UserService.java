package cinimex.services;

import cinimex.DTO.UserDto;
import cinimex.JPArepository.UserRepository;
import cinimex.entity.UsersEntity;
import cinimex.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto createUser(UserDto newUserDto) throws Exception {
        if (newUserDto == null)
            throw new Exception("dto для создания юзера Null");
        UsersEntity newUser = userMapper.fromDto(newUserDto);
        UsersEntity savedUser = userRepository.save(newUser);
        return userMapper.toDto(savedUser);
    }

    public boolean deleteUser(Long id) throws Exception {
        if (userRepository.findById(id).isEmpty())
            throw new Exception("(попытка удаления) - юзера с данным id=" + id.toString() + " не существует");
        userRepository.deleteById(id);
        return true;

    }
    public UserDto updateUser(UserDto updateUserDto) throws Exception {
        if (updateUserDto == null)
            throw new Exception("dto для обовления данных юзера Null");
        UsersEntity updateUser = userMapper.fromDto(updateUserDto);
        UsersEntity updatedUser =   userRepository.save(updateUser);
        return userMapper.toDto(updatedUser);
    }
    public List<UserDto> getAllUser(){
        List<UsersEntity> allUsers = userRepository.findAll();
        return userMapper.toDto(allUsers);
    }
}
