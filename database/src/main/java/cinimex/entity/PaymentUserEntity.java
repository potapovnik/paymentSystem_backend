package cinimex.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "payment_user", schema = "public", catalog = "payment_system")
@Data
public class PaymentUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_user_seq")
    @SequenceGenerator(name = "payment_user_seq", sequenceName = "payment_user_id_seq", allocationSize = 1)
    private Long id;
    private Integer money;
    private Boolean paid;
    @Column(name = "payment_company_id")
    private Long paymentId;
    @Column(name = "user_id")
    private Long userId;

}
