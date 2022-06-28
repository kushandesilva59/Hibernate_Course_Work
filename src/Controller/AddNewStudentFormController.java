package Controller;

import com.jfoenix.controls.JFXDatePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AddNewStudentFormController {

    public AnchorPane addNewStudentContext;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtContact;
    public RadioButton radioMale;
    public RadioButton radioFemale;
    public JFXDatePicker dateBirthday;

    public void addOnAction(ActionEvent event) {
    }

    public void cancelOnAction(ActionEvent event) throws IOException {
        loadUi("MakeReservationForm");
    }

    public void loadUi(String location) throws IOException {
        Stage stage = (Stage) addNewStudentContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
