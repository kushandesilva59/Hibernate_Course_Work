package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Room {
    @Id
    private String roomId;
    private String type;
    private double keyMoney;
    private int qty;

    @ManyToMany
    private List<Student> studentList = new ArrayList();
}
