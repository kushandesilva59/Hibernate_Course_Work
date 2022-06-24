package Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ReserveDto {
    private String reserveId;
    private Date date;
    private double keyMoney;
    private String studentId;
    private String roomId;

}
