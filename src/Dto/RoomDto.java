package Dto;

public class RoomDto {
    private String roomId;
    private String type;
    private double monthlyRent;
    private int qty;

    public RoomDto() {
    }

    public RoomDto(String roomId, String type, double monthlyRent, int qty) {
        this.roomId = roomId;
        this.type = type;
        this.monthlyRent = monthlyRent;
        this.qty = qty;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId='" + roomId + '\'' +
                ", type='" + type + '\'' +
                ", monthlyRent=" + monthlyRent +
                ", qty=" + qty +
                '}';
    }
}
