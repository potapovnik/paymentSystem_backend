package cinimex.DTO;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class JournalDto {
    private long id;
    private Integer money;
    private Timestamp time;
    private String transferText;
    private Long transferId;
    private Long operationId;
}
