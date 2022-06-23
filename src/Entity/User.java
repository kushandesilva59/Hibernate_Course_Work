package Entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
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

    public User() {
    }

    public User(String userId, String name, String address, String contact, Date birthday, String gender, String password) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.birthday = birthday;
        this.gender = gender;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
