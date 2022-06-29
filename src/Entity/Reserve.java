package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reserve {
    @Id
    private String reserveId;
    private String date;
    private String status;

    @ManyToOne()
    private Student student;

    @ManyToOne()
    private Room room;
}
