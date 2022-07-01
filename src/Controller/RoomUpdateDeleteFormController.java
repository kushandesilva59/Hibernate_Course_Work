package Controller;

import BO.Custom.Impl.RoomBoImpl;
import BO.Custom.RoomBo;
import DAO.Custom.Impl.QueryDaoImpl;
import DAO.Custom.QueryDao;
import Entity.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.regex.Pattern;

public class RoomUpdateDeleteFormController {
    public AnchorPane updateOrDeleteContext;
    public TableView<Room> tblRooms;
    public TableColumn colRoomId;
    public TableColumn colRoomType;
    public TableColumn colKeyRental;
    public TableColumn colQTY;
    public TextField txtRoomId;
    public TextField txtRoomType;
    public TextField txtKeyRental;
    public TextField txtQTY;
    public Button btnDelete;
    RoomBo roomBo = new RoomBoImpl();
    QueryDao queryDao = new QueryDaoImpl();



    public void initialize() throws SQLException, ClassNotFoundException, IOException {
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
        txtKeyRental.setStyle("-fx-border-color: gray");
        txtRoomId.setStyle("-fx-border-color: gray");
        txtRoomType.setStyle("-fx-border-color: gray");
        txtQTY.setStyle("-fx-border-color: gray");
        btnDelete.setText("Delete");
        txtRoomId.setText(room.getRoomId());
        txtRoomType.setText(room.getType());
        txtKeyRental.setText(String.valueOf(room.getKeyMoney()));
        txtQTY.setText(String.valueOf(room.getQty()));
    }

    public void deleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        if (btnDelete.getText().equals("Delete")) {
            Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ?").showAndWait();
            if (buttonType.get().equals(ButtonType.OK)) {

                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!..").show();
                String roomId = txtRoomId.getText();

                queryDao.deleteReserveByRoomId(roomId);
                roomBo.delete(roomId);

                Room room = tblRooms.getSelectionModel().getSelectedItem();
                tblRooms.getItems().remove(room);
                tblRooms.refresh();
                clearText();
            }
        } else {
            String roomId = txtRoomId.getText();
            String roomType = txtRoomType.getText();
            double keyRental = Double.valueOf(txtKeyRental.getText());
            int qty = Integer.valueOf(txtQTY.getText());

            Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION, "Room Updated!..").showAndWait();
            if (buttonType.get().equals(ButtonType.OK)) {

                Room room = tblRooms.getSelectionModel().getSelectedItem();
                room.setQty(Integer.valueOf(txtQTY.getText()));
                room.setType(txtRoomType.getText());
                room.setKeyMoney(Double.valueOf(txtKeyRental.getText()));
                tblRooms.refresh();
                clearText();
                roomBo.update(new Room(roomId, roomType, keyRental, qty));

                tblRooms.refresh();
            }
        }
    }

    public void backOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) updateOrDeleteContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ManageRoomsForm.fxml"))));
    }

    public void setRooms() throws SQLException, ClassNotFoundException, IOException {
        ObservableList<Room> rooms = FXCollections.observableArrayList();
        RoomBo roomBo = new RoomBoImpl();
        ArrayList<Room> all = roomBo.getAll();

        for (Room room : all) {
            rooms.add(room);
        }
        tblRooms.setItems(rooms);
    }

    public void keyReleasedOnAction(KeyEvent keyEvent) {
        validate();
        btnDelete.setText("Update");
    }

    private Object validate() {
        LinkedHashMap<TextField, Pattern> map = new LinkedHashMap<>();

        Pattern keyMoneyPattern = Pattern.compile("^[0-9.]{3,15}$");
        Pattern qtyPattern = Pattern.compile("^[0-9]{1,4}$");

        map.put(txtKeyRental, keyMoneyPattern);
        map.put(txtQTY, qtyPattern);

        for (TextField key : map.keySet()) {
            Pattern pattern = map.get(key);
            if (pattern.matcher(key.getText()).matches()) {
                setGreen(key);
            } else {
                setRed(key);
                return key;
            }
        }
        return true;
    }

    private void setGreen(TextField textField) {
        if (textField.getLength() > 0) {
            btnDelete.setDisable(false);
            textField.setStyle("-fx-border-color: #01ff00");
        }
    }

    private void setRed(TextField textField) {
        if (textField.getLength() > 0) {
            btnDelete.setDisable(true);
            textField.setStyle("-fx-border-color: #ff001b");
        }
    }

    public void clearText() {
        txtRoomId.clear();
        txtRoomType.clear();
        txtKeyRental.clear();
        txtQTY.clear();
    }
}
