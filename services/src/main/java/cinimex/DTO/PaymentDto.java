package cinimex.DTO;

import lombok.Data;

@Data
public class PaymentDto {
    private TransferDto transfer;
    private PaymentUserDto paymentUser;
}
