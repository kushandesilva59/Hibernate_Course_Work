package Controller;

import BO.Custom.Impl.UserBoImpl;
import Entity.User;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.org.apache.bcel.internal.generic.LADD;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {

    public AnchorPane loginFormContext;
    public TextField txtUsername;
    public PasswordField pwdPassword;
    public TextField txtPassword;
    public CheckBox checkBoxShow;

    public void initialize(){
        txtPassword.setVisible(false);
    }

    public void loginOnAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        loadUi("MainForm");

       /* UserBoImpl userBo = new UserBoImpl();
        User user = userBo.search(txtUsername.getText());

        if(user != null){
            System.out.println("Done!");
            if(pwdPassword.getText().equals(user.getPassword())){
                loadUi("MainForm");
            }else {
                new Alert(Alert.AlertType.WARNING,"Incorrect Password!").show();
            }
        }else{
            new Alert(Alert.AlertType.WARNING,"Incorrect UserId!..").show();
        }*/

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


    public void doneOnAction(ActionEvent event) {
        if(checkBoxShow.isSelected()){
            String passwordText = pwdPassword.getText();
            txtPassword.setText(passwordText);
            pwdPassword.setVisible(false);
            txtPassword.setVisible(true);
        }else{
            txtPassword.setVisible(false);
            pwdPassword.setVisible(true);
        }
    }
}
