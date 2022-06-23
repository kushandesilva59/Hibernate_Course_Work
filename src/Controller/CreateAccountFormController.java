package Controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.time.LocalDate;
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

    public void addAccountOnAction(ActionEvent event) {
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();

        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        String gender = selectedRadioButton.getText();

        LocalDate value = dateBirthday.getValue();
        String birthDay = value.toString();

    }




    public void keyReleasedOnAction(KeyEvent keyEvent) {
        validate();
    }

    private void enableButton() {

        if(dateBirthday.getValue()==null){

        }else{

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
        enableButton();
    }
}
