package cinimex.DTO;

import lombok.Data;

import javax.persistence.*;

@Data
public class CompanyDto {

    private Long id;
    private String name;
    private Long balanceId;
    private Integer numberOfCard;

}
