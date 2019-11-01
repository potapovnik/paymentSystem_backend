package cinimex.DTO;

import lombok.Data;

import javax.persistence.*;

@Data
public class PaymentCompanyDto {

    private Long id;
    private String name;
    private Integer amount;
    private Long companyId;

}
