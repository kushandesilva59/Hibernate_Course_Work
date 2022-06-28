package Controller;

import BO.Custom.Impl.RoomBoImpl;
import BO.Custom.RoomBo;
import Entity.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;
import java.util.ArrayList;

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
    public Button btnDelete;

    public void initialize() throws SQLException, ClassNotFoundException {
        colRoomId.setCellValueFactory(new PropertyValueFactory("roomId"));
        colRoomType.setCellValueFactory(new PropertyValueFactory("type"));
        colKeyRental.setCellValueFactory(new PropertyValueFactory("keyMoney"));
        colQTY.setCellValueFactory(new PropertyValueFactory("qty"));
        txtRoomId.setEditable(false);

        tblRooms.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setRoomDetails(newValue);
        });
        setRooms();
    }

    private void setRoomDetails(Room room) {
        txtRoomId.setText(room.getRoomId());
        txtRoomType.setText(room.getType());
        txtKeyRental.setText(String.valueOf(room.getKeyMoney()));
        txtQTY.setText(String.valueOf(room.getQty()));
    }

    public void deleteOnAction(ActionEvent event) {

    }

    public void backOnAction(ActionEvent event) {

    }

    public void setRooms() throws SQLException, ClassNotFoundException {
        ObservableList <Room> rooms = FXCollections.observableArrayList();
        RoomBo roomBo = new RoomBoImpl();
        ArrayList<Room> all = roomBo.getAll();

        for(Room room : all){
            rooms.add(room);
        }
        tblRooms.setItems(rooms);
    }

    public void keyReleasedOnAction(KeyEvent keyEvent) {

    }
}
