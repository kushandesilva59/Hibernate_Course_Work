package Controller;

import BO.Custom.Impl.RoomBoImpl;
import BO.Custom.Impl.StudentBoImpl;
import BO.Custom.RoomBo;
import BO.Custom.StudentBo;
import Entity.Room;
import Entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
    public TextField txtRoomKeyMoney;
    public TextField txtRoomQTY;
    public TextField txtRoomType;
    public RadioButton radioKeyRental;


    RoomBo roomBo = new RoomBoImpl();
    StudentBo studentBo = new StudentBoImpl();

    public void initialize() throws SQLException, ClassNotFoundException {
        setEditableTextFields();
        loadRooms();
        loadStudentIds();
        comboStudentIds.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            try {
                setStudentDetails(newValue);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        comboRooms.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                setRoomDetails(newValue);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    private void setRoomDetails(String roomId) throws SQLException, ClassNotFoundException {
        Room room = roomBo.search(roomId);
        txtRoomType.setText(room.getType());
        txtRoomKeyMoney.setText("Rs."+String.valueOf(room.getKeyMoney()));
        txtRoomQTY.setText(String.valueOf(room.getQty()));
    }

    private void setStudentDetails(String studentId) throws SQLException, ClassNotFoundException {
        Student student = studentBo.search(studentId);
        txtStudentName.setText(student.getName());
        txtStudentAddress.setText(student.getAddress());
        txtStudentContact.setText(student.getContact());
        txtStudentBDay.setText(student.getBirthday());
    }

    private void loadStudentIds() {
        ObservableList<String> allStudentIds = studentBo.getAllStudentIds();
        comboStudentIds.setItems(allStudentIds);
    }

    private void loadRooms() throws SQLException, ClassNotFoundException {
        ObservableList <String> roomIds = FXCollections.observableArrayList();
        ArrayList<Room> all = roomBo.getAll();

        for(Room room : all){
            roomIds.add(room.getRoomId());
        }

        comboRooms.setItems(roomIds);
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

    public void setEditableTextFields(){
        txtStudentName.setEditable(false);
        txtStudentAddress.setEditable(false);
        txtStudentContact.setEditable(false);
        txtStudentBDay.setEditable(false);
        txtRoomType.setEditable(false);
        txtRoomKeyMoney.setEditable(false);
        txtRoomQTY.setEditable(false);
    }
}
