package Controller;

import BO.Custom.Impl.UserBoImpl;
import BO.Custom.UserBo;
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
import org.hibernate.query.Query;

import java.io.IOException;

public class ChangePasswordFormController {
    public AnchorPane changePasswordContext;
    public PasswordField pwdConfirmation;
    public PasswordField pwdNewPassword;
    public PasswordField pwdOldPassword;
    private static String userId;
    UserBo userBo = new UserBoImpl();

    public void loadUi(String location) throws IOException {
        Stage stage = (Stage) changePasswordContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }

    public void doneOnAction(ActionEvent event) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        User user = session.get(User.class, userId);

        boolean oldPasswordCorrect = userBo.checkOldPassword(user, pwdOldPassword.getText());

        if(oldPasswordCorrect){
            boolean passwordConfirmed = userBo.passwordConfirmed(pwdNewPassword.getText(), pwdConfirmation.getText());
            if(passwordConfirmed){
                Query query = session.createQuery("UPDATE User SET password =: newPassword WHERE userId =: userId");
                query.
                new Alert(Alert.AlertType.CONFIRMATION,"Password Changed!..").show();
                loadUi("MainForm");
            }else{
                new Alert(Alert.AlertType.WARNING,"New Password not matched!..").show();
            }
        }else{
            new Alert(Alert.AlertType.WARNING,"Old password is incorrect!..").show();
        }
    }

    public void cancelOnAction(ActionEvent event) throws IOException {
        loadUi("MainForm");
    }

    public void setUserId(String id){
        userId = id;
    }
}
