package Controller;

import BO.Custom.Impl.RoomBoImpl;
import BO.Custom.Impl.StudentBoImpl;
import BO.Custom.RoomBo;
import BO.Custom.StudentBo;
import Entity.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MakeReservationFormController {

    public AnchorPane makeReservationContext;
    public ComboBox <String>comboRooms;
    public Label lblDate;
    public ComboBox <String>comboStudentIds;
    public TextField txtStudentName;
    public TextField txtStudentBDay;
    public TextField txtStudentContact;
    public TextField txtStudentAddress;
    public TextField txtRoomId;
    public TextField txtRoomKeyMoney;
    public TextField txtRoomQTY;


    RoomBo roomBo = new RoomBoImpl();
    StudentBo studentBo = new StudentBoImpl();



    public void initialize() throws SQLException, ClassNotFoundException {
        loadRooms();
        loadStudentIds();
    }

    private void loadStudentIds() {
        ObservableList<String> allStudentIds = studentBo.getAllStudentIds();
        comboStudentIds.setItems(allStudentIds);
    }

    private void loadRooms() throws SQLException, ClassNotFoundException {
        ObservableList <String> roomNames = FXCollections.observableArrayList();
        ArrayList<Room> all = roomBo.getAll();

        for(Room room : all){
            roomNames.add(room.getType());
        }

        comboRooms.setItems(roomNames);
    }

    public void addNewStudentOnAction(ActionEvent event) throws IOException {
        loadUi("AddNewStudentForm");
    }

    public void reserveOnAction(ActionEvent event) {

    }

    public void cancelOnAction(ActionEvent event) throws IOException {
        loadUi("MainForm");
    }

    public void loadUi(String location) throws IOException {
        Stage stage = (Stage) makeReservationContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
