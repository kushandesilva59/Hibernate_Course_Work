package Controller;

import Entity.Room;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RoomUpdateDeleteFormController {
    public AnchorPane updateOrDeleteContext;
    public TableView <Room>tblRooms;
    public TableColumn colRoomId;
    public TableColumn colRoomType;
    public TableColumn colKeyRental;
    public TableColumn colQTY;
    public TextField txtRoomId;
    public TextField txtRoomType;
    public TextField txtKeyRental;
    public TextField txtQTY;

    public void deleteOnAction(ActionEvent event) {
        
    }

    public void backOnAction(ActionEvent event) {

    }
}
