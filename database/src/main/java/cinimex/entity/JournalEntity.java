package cinimex.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "journal", schema = "public", catalog = "payment_system")
@Data
public class JournalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "journal_seq")
    @SequenceGenerator(name = "journal_seq", sequenceName = "journal_id_seq", allocationSize = 1)
    private long id;
    private Integer money;
    private Timestamp time;
    @Column(name = "transfer_text")
    private String transferText;
}
