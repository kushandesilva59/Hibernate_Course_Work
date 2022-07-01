package Controller;

import BO.BoFactory;
import BO.Custom.Impl.StudentBoImpl;
import BO.Custom.StudentBo;
import Entity.Student;
import com.jfoenix.controls.JFXDatePicker;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.regex.Pattern;


public class AddNewStudentFormController {
    StudentBo studentBo = (StudentBo) BoFactory.getBoFactory().getBO(BoFactory.BOTypes.STUDENT);


    public AnchorPane addNewStudentContext;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtContact;
    public RadioButton radioMale;
    public RadioButton radioFemale;
    public JFXDatePicker dateBirthday;
    public Button btnAdd;
    private ToggleGroup group = new ToggleGroup();

    public void initialize(){
        btnAdd.setDisable(true);
        radioMale.setToggleGroup(group);
        radioFemale.setToggleGroup(group);
    }

    public void addOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        Student student = new Student();

        student.setStudentId(studentBo.generateNewID());
        student.setName(txtName.getText());
        student.setAddress(txtAddress.getText());
        student.setContact(txtContact.getText());
        student.setBirthday(dateBirthday.getValue().toString());

        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        String gender = selectedRadioButton.getText();
        student.setGender(gender);


        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION, "Student Saved!..").showAndWait();
        if(buttonType.get().equals(ButtonType.OK)){
            studentBo.save(student);
            loadUi("MakeReservationForm");
        }

    }

    public void cancelOnAction(ActionEvent event) throws IOException {
        loadUi("MakeReservationForm");
    }

    public void loadUi(String location) throws IOException {
        Stage stage = (Stage) addNewStudentContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
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

    public void keyReleasedOnAction(KeyEvent keyEvent) {
        validate();
    }

    public void isSelected(ActionEvent event) {
        String nameStyle = txtName.getStyle();
        String addressStyle = txtAddress.getStyle();
        String contactStyle = txtContact.getStyle();

        if(nameStyle.equals("-fx-border-color: #ff001b") || addressStyle.equals("-fx-border-color: #ff001b") || contactStyle.equals("-fx-border-color: #ff001b")){
            new Alert(Alert.AlertType.WARNING,"Something went wrong !..").show();

        }else {
            btnAdd.setDisable(false);

        }
    }
}
