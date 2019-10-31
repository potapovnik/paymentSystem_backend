package cinimex.DTO;

import lombok.Data;

@Data
public class BalanceDto {
    private long id;
    private Integer money;
    private String numberOfBalance;
    private boolean isLock;
    private Long userId;
}
