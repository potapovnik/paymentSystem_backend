package cinimex.entity;

import cinimex.enums.OperationType;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "operation", schema = "public", catalog = "payment_system")
@Data
public class OperationEntity {

    @Id
    private long id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private OperationType operation;


}
