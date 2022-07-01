package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class MainFormController {

    public AnchorPane mainFormContext;
    public static String userId;

    public void logOutOnAction(ActionEvent event) throws IOException {
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ?").showAndWait();
        if(buttonType.get().equals(ButtonType.OK)){
            loadUi("LoginForm");
        }
    }

    public void makeReservationOnAction(ActionEvent event) throws IOException {
        loadUi("MakeReservationForm");
    }

    public void changePasswordOnAction(ActionEvent event) throws IOException {
        ChangePasswordFormController changePasswordFormController = new ChangePasswordFormController();
        changePasswordFormController.setUserId(userId);
        loadUi("ChangePasswordForm");
    }

    public void loadUi(String location) throws IOException {
        Stage stage = (Stage) mainFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }


    public void setUserId(String id){
        userId = id;
    }

    public void manageRoomOnAction(ActionEvent event) throws IOException {
        loadUi("ManageRoomsForm");
    }

    public void manageStudentsOnAction(ActionEvent event) throws IOException {
       // loadUi("ManageStudentsForm");
        loadUi("StudentManageForm");
    }
}
