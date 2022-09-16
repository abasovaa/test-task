package kg.megacom.testTask.mappers;

import kg.megacom.testTask.models.User;
import kg.megacom.testTask.models.dtos.UserDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);
    User UserDtoToUser(UserDto userDto);
}
