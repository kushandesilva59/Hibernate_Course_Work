package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class User {
    @Id
    private String userId;
    private String name;
    private String address;
    private String contact;
    private Date birthday;
    private String gender;
    private String password;

}
