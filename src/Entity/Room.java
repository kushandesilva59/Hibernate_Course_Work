package Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {
    @Id
    private String roomId;
    private String type;
    private double monthlyRent;
    private int qty;

    @ManyToMany
    private List<Student> studentList = new ArrayList();
}
