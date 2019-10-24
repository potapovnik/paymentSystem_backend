package cinimex.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "balance", schema = "public", catalog = "payment_system")
@Data
public class BalanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "balance_seq")
    @SequenceGenerator(name = "balance_seq", sequenceName = "balance_id_seq", allocationSize = 1)
    private long id;
    private Integer money;
    @Column(name = "number_of_balance")
    private String numberOfBalance;


}
