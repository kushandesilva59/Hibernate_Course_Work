package Controller;

import BO.Custom.Impl.RoomBoImpl;
import BO.Custom.Impl.StudentBoImpl;
import BO.Custom.RoomBo;
import BO.Custom.StudentBo;
import DAO.Custom.Impl.StudentDaoImpl;
import DAO.Custom.StudentDao;
import Entity.Room;
import Entity.Student;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MakeReservationFormController {

    public AnchorPane makeReservationContext;
    public ComboBox <String>comboRooms;
    public Label lblDate;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentAddress;
    public JFXTextField txtStudentContact;
    public JFXTextField txtStudentBDay;
    public JFXTextField txtRoomId;
    public JFXTextField txtRoomKeyMoney;
    public JFXTextField txtRoomQTY;
    public TextField txtStudentId;
    RoomBo roomBo = new RoomBoImpl();


    public void initialize() throws SQLException, ClassNotFoundException {
        loadRooms();
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

    public void validate(){

    }

    public void keyReleasedOnAction(KeyEvent keyEvent) {
        validate();
    }

    public void searchOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String text = txtStudentId.getText();
        StudentDao studentDao = new StudentDaoImpl();
        Student student = studentDao.search(text);
        if(student != null){
            txtStudentName.setText(student.getName());
            txtStudentAddress.setText(student.getAddress());
            txtStudentContact.setText(student.getContact());
            txtStudentBDay.setText(String.valueOf(student.getBirthday()));
        }else {
            new Alert(Alert.AlertType.WARNING,"Incorrect Student ID !..").show();
        }
    }
}
