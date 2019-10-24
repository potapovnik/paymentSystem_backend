package cinimex.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "transfer", schema = "public", catalog = "payment_system")
@Data
public class TransferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transfer_seq")
    @SequenceGenerator(name = "transfer_seq", sequenceName = "transfer_id_seq", allocationSize = 1)
    private long id;


}
