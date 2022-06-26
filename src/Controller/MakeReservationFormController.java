package Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MakeReservationFormController {

    public AnchorPane makeReservationContext;
    public ComboBox <String>comboStudentIds;
    public ComboBox <String>comboRooms;
    public Label lblDate;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentAddress;
    public JFXTextField txtStudentContact;
    public JFXTextField txtStudentBDay;
    public JFXTextField txtRoomId;
    public JFXTextField txtRoomKeyMoney;
    public JFXTextField txtRoomQTY;

    public void addNewStudentOnAction(ActionEvent event) {

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
