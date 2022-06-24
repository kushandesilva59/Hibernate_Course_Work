package Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class RoomDto {
    private String roomId;
    private String type;
    private double monthlyRent;
    private int qty;

}
