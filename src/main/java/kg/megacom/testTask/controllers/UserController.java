package kg.megacom.testTask.controllers;

import kg.megacom.testTask.models.dtos.UserDto;
import kg.megacom.testTask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value="/api/v1/user")
public class UserController {

    @Autowired
    private final UserService userService;


    private UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/upload")
    private String URL(@RequestPart MultipartFile file){
        return userService.addImageToUser(file);
    }

    @PostMapping("/save")
    private UserDto save(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @PostMapping("/addUser")
    private UserDto addUser(@RequestBody UserDto userDto) {

        return userService.addUser(userDto);
    }

    /*@PostMapping("/add/file")
    private addImageToUser(@RequestParam Long id, @RequestPart MultipartFile file) {
        User user = userService.getById(id);
        return userService.addImageToUser(UserMapper.INSTANCE.userToUserDto(user));
    }*/
}
