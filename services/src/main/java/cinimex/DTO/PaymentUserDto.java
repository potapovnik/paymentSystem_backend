package cinimex.DTO;

import lombok.Data;


@Data
public class PaymentUserDto {
    private Long id;
    private Boolean paid;
    private Long paymentId;
    private Long userId;

}
