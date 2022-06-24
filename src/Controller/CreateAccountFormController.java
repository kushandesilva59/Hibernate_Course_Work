package Controller;

import DAO.Custom.Impl.UserDaoImpl;
import Dto.ReserveDto;
import Dto.UserDto;
import Entity.Reserve;
import Entity.User;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class CreateAccountFormController {
    public PasswordField pwdPassword;
    public PasswordField pwdConfirmPassword;
    public JFXDatePicker dateBirthday;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtContact;
    public AnchorPane createAccountContext;
    public Button btnAddAccount;
    public JFXRadioButton maleButton;
    public JFXRadioButton femaleButton;
    private ToggleGroup group = new ToggleGroup();


    public void initialize(){
            btnAddAccount.setDisable(true);
            maleButton.setToggleGroup(group);
            femaleButton.setToggleGroup(group);
    }

    public void addAccountOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();

        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        String gender = selectedRadioButton.getText();

        LocalDate value = dateBirthday.getValue();
        String birthDay = value.toString();

        String password = pwdPassword.getText();
        String confirmation = pwdConfirmPassword.getText();
        if(password.equals(confirmation)){
            User u001 = new User("U001", name, address, contact, Date.valueOf(birthDay), gender, password);


            UserDaoImpl userDao = new UserDaoImpl();
            userDao.save(u001);

        }else{
            new Alert(Alert.AlertType.WARNING,"Password not matched!..").show();
        }
    }

    public void keyReleasedOnAction(KeyEvent keyEvent) {
        validate();
    }

    private boolean ifDatePicked() {
        if(dateBirthday.getValue()==null){
            return false;
        }else{
            return true;
        }
    }

    public Object isGenderSelected(){
       if(maleButton.isSelected()){
           return "Male";
       }else if (femaleButton.isSelected()){
           return "female";
       }else{
           return null;
       }
    }

    private Object validate(){
        LinkedHashMap<TextField, Pattern> map = new LinkedHashMap<>();

        Pattern namePattern = Pattern.compile("^[A-z ]{3,15}$");
        Pattern addressPattern = Pattern.compile("^[A-z ]{4,20}$");
        Pattern contactPattern = Pattern.compile("^[0-9]{3}(-)[0-9]{7}$");

        map.put(txtName,namePattern);
        map.put(txtAddress,addressPattern);
        map.put(txtContact,contactPattern);

        for(TextField key : map.keySet()){
            Pattern pattern =  map.get(key);
            if(!pattern.matcher(key.getText()).matches()){
                setRed(key);
                return key;
            }
            setGreen(key);
        }
        return true;
    }

    private void setGreen(TextField textField) {
        if(textField.getLength() > 0) {
            textField.setStyle("-fx-border-color: #01ff00");
        }
    }

    private void setRed(TextField textField) {
        if(textField.getLength() > 0){
            textField.setStyle("-fx-border-color: #ff001b");
        }
    }

    public void checkPasswordOnAction(KeyEvent keyEvent) {
        boolean ifDatePicked = ifDatePicked();
        Object genderSelected = isGenderSelected();
        if(genderSelected == null){

        }else{
            if(ifDatePicked){
                btnAddAccount.setDisable(false);
            }
        }
    }

    public void cancelOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) createAccountContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"))));
        stage.show();
    }
}
