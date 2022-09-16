package kg.megacom.testTask.services;

import kg.megacom.testTask.models.User;
import kg.megacom.testTask.models.dtos.UserDto;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    UserDto save(UserDto userDto);

    User getById(Long id);

    User update(User user);

    String addImageToUser(MultipartFile file);

    UserDto addUser(UserDto userDto);


}
