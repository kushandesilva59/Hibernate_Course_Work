package Controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    public AnchorPane loginFormContext;
    public JFXPasswordField pwdPassword;
    public JFXTextField txtUsername;

    public void loginOnAction(ActionEvent event) throws IOException {
        loadUi("MainForm");

    }


    public void loadUi(String location) throws IOException {
        if(location.equals("MainForm")){
            MainFormController mainFormController = new MainFormController();
            mainFormController.setUserId(txtUsername.getText());
        }
        Stage stage = (Stage) loginFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }

    public void createAccountOnActionLabel(MouseEvent mouseEvent) throws IOException {
        loadUi("CreateAccountForm");
    }

    public void showPasswordOnAction(MouseEvent mouseEvent) {

    }

}
