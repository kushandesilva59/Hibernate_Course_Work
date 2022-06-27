package Controller;

import Entity.User;
import Util.FactoryConfiguration;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;

public class ChangePasswordFormController {
    public AnchorPane changePasswordContext;
    public PasswordField pwdConfirmation;
    public PasswordField pwdNewPassword;
    public PasswordField pwdOldPassword;
    private static String userId;

    public void loadUi(String location) throws IOException {
        Stage stage = (Stage) changePasswordContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }

    public void doneOnAction(ActionEvent event) {
        Session session = FactoryConfiguration.getInstance().getSession();
        User user = session.get(User.class, userId);



    }

    public void cancelOnAction(ActionEvent event) throws IOException {
        loadUi("MainForm");
    }

    public void setUserId(String id){
        userId = id;
    }

    public boolean checkOldPassword(){
        if(user.getPassword().equals(pwdOldPassword.getText())){

        }else{
            new Alert(Alert.AlertType.WARNING,"Something went wrong!..").show();
        }
    }
}
