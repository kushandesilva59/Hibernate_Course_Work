package TM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentPaymentTM {
    String studentId;
    String studentName;
    String roomId;
    String contact;
    double payment;
}
