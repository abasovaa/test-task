package kg.megacom.testTask.services.impl;

import kg.megacom.testTask.mappers.UserMapper;
import kg.megacom.testTask.microServices.FileServiceFeign;
import kg.megacom.testTask.microServices.json.Response;
import kg.megacom.testTask.models.User;
import kg.megacom.testTask.models.dtos.UserDto;
import kg.megacom.testTask.models.repositories.UserRepo;
import kg.megacom.testTask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final FileServiceFeign fileServiceFeign;
    @Autowired
    private final UserRepo userRepo;

    private final UserMapper userMapper;

    public UserServiceImpl(FileServiceFeign fileServiceFeign, UserRepo userRepo) {
        this.fileServiceFeign = fileServiceFeign;
        this.userRepo = userRepo;
        this.userMapper = UserMapper.INSTANCE;
    }

    @Override
    public UserDto save(UserDto userDto) {

        User user=userMapper.UserDtoToUser(userDto);
        user=userRepo.save(user);

        return userMapper.userToUserDto(user);
    }

    @Override
    public User getById(Long id) {
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("Пользователь не найден!"));
    }

    @Override
    public User update(User user) {
        if (userRepo.existsById(user.getId())){
            return userRepo.save(user);
        }
        return null;
    }

    @Override
    public String addImageToUser(MultipartFile file) {
        Response response=fileServiceFeign.upload(file);
        return response.getDownloadUri();
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user=userMapper.UserDtoToUser(userDto);
        user=userRepo.save(user);
        return save(userDto);
    }
}
