package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {

    public AnchorPane mainFormContext;

    public void logOutOnAction(ActionEvent event) throws IOException {
        loadUi("LoginForm");
    }

    public void makeReservationOnAction(ActionEvent event) throws IOException {
        loadUi("MakeReservationForm");
    }

    public void changePasswordOnAction(ActionEvent event) throws IOException {
        loadUi("ChangePasswordForm");
    }

    public void findSStudentOnAction(ActionEvent event) {

    }

    public void loadUi(String location) throws IOException {
        Stage stage = (Stage) mainFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }

    public void addRoomOnAction(ActionEvent event) throws IOException {
        loadUi("AddRoomForm");
    }
}
