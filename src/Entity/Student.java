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
    private String birthday;
    private String gender;

    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER)
    private List<Reserve> reserveList;

    public Student(String studentId, String name, String address, String contact, String birthday, String gender) {
        this.studentId = studentId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.birthday = birthday;
        this.gender = gender;

    }
}
