package cinimex.DTO;

import lombok.Data;

import javax.persistence.*;

@Data
public class PaymentUserDto {
    private Long id;
    private Integer money;
    private Boolean paid;
    private Long paymentId;
    private Long userId;

}
