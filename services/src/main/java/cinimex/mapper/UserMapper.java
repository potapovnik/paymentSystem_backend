package cinimex.mapper;

import cinimex.DTO.UserDto;
import cinimex.entity.UsersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UsersEntity fromDto(UserDto userDto);

    @Mapping(target = "password", ignore = true)
    UserDto toDto(UsersEntity usersEntity);

    List<UsersEntity> fromDto(List<UserDto> userDtos);

    List<UserDto> toDto(List<UsersEntity> usersEntities);
}
