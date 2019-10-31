package cinimex.DTO;

import cinimex.entity.JournalEntity;
import lombok.Data;

@Data
public class TransferDto {
    private JournalDto journal;
    private String fromBalance;
    private String toBalance;
}
