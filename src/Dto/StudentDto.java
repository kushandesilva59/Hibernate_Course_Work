package Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class StudentDto {
    private String studentId;
    private String name;
    private String address;
    private String contact;
    private Date birthday;
    private String gender;

}
