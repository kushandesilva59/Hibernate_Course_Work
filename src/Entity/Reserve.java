package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Reserve {
    @Id
    private String reserveId;
    private Date date;
    private double keyMoney;
    private String studentId;
    private String roomId;

}
