package cinimex.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "public", catalog = "payment_system")
@Data
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_id_seq", allocationSize = 1)
    private long id;
    private String name;
    private String surname;
    private String lastname;
    private String login;
    private String password;
    @Column(name = "date_registration")
    private Timestamp dateRegistration;
    private Timestamp dob;
}
