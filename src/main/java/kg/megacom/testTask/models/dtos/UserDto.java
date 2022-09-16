package kg.megacom.testTask.models.dtos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserDto {

    Long id;
    String name;
    String email;
    String imageUri;
    boolean isOnline;

}
