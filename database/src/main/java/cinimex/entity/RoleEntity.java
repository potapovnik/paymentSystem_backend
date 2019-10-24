package cinimex.entity;

import cinimex.enums.RoleType;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "role", schema = "public", catalog = "payment_system")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    @SequenceGenerator(name = "role_seq", sequenceName = "role_id_seq", allocationSize = 1)
    private long id;
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private RoleType role;

}
