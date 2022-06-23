package Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
@Entity
public class Reserve {
    @Id
    private String reserveId;
    private Date date;
    private double keyMoney;
    private String studentId;
    private String roomId;

    public Reserve() {
    }

    public Reserve(String reserveId, Date date, double keyMoney, String studentId, String roomId) {
        this.reserveId = reserveId;
        this.date = date;
        this.keyMoney = keyMoney;
        this.studentId = studentId;
        this.roomId = roomId;
    }

    public String getReserveId() {
        return reserveId;
    }

    public void setReserveId(String reserveId) {
        this.reserveId = reserveId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getKeyMoney() {
        return keyMoney;
    }

    public void setKeyMoney(double keyMoney) {
        this.keyMoney = keyMoney;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "reserveId='" + reserveId + '\'' +
                ", date=" + date +
                ", keyMoney=" + keyMoney +
                ", studentId='" + studentId + '\'' +
                ", roomId='" + roomId + '\'' +
                '}';
    }
}
