package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {
    @Id
    private String studentId;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String address;
    private String contact;
    private Date birthday;
    private String gender;

    @ManyToMany(mappedBy = "studentList")
    private List<Room> roomList = new ArrayList();
}