package cinimex.entity;

import cinimex.enums.RoleType;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "role", schema = "public", catalog = "payment_system")
@Data
public class RoleEntity {
    @Id
    private long id;
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private RoleType role;

}
