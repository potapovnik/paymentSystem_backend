package cinimex.entity;

import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "public", catalog = "payment_system")
@Data
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @SequenceGenerator(name = "users_seq", sequenceName = "users_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String surname;
    private String lastname;
    private String login;
    private String password;
    @Column(name = "date_registration")
    private Timestamp dateRegistration;
    private Timestamp dob;
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "is_deleted")
    private boolean deleted;
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    public void setPassword(String password) {
        if (password == null)
            setPasswordWithoutEncode(password);
        else
            this.password = PASSWORD_ENCODER.encode(password);
    }

    public void setPasswordWithoutEncode(String password) {
        this.password = password;
    }
}