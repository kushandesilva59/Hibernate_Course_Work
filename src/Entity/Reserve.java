package Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
