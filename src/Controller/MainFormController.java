package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {

    public AnchorPane mainFormContext;
    public static String userId;

    public void logOutOnAction(ActionEvent event) throws IOException {
        loadUi("LoginForm");
    }

    public void makeReservationOnAction(ActionEvent event) throws IOException {
        loadUi("MakeReservationForm");
    }

    public void changePasswordOnAction(ActionEvent event) throws IOException {
        ChangePasswordFormController changePasswordFormController = new ChangePasswordFormController();
        changePasswordFormController.setUserId(userId);
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

    public void setUserId(String id){
        userId = id;
    }
}
