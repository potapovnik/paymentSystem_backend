package cinimex.DTO;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String lastname;
    private String login;
    private String password;
    private Timestamp dateRegistration;
    private Timestamp dob;
}
