package Controller;

import BO.BoFactory;
import BO.Custom.Impl.QueryBoImpl;
import BO.Custom.Impl.ReserveBoImpl;
import BO.Custom.Impl.StudentBoImpl;
import BO.Custom.QueryBo;
import BO.Custom.ReserveBo;
import BO.Custom.StudentBo;
import DAO.Custom.Impl.QueryDaoImpl;
import Entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.regex.Pattern;

public class StudentManageFormController {
    public AnchorPane studentManageContext;
    public TableView <Student>tblStudents;
    public TableColumn colStudentId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colBirthday;
    public TableColumn colGender;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtContact;
    public ComboBox <String>comboGender;
    public DatePicker dateBirthDay;
    public Button btnSave;
    public Button btnDelete;
    StudentBo studentBo = (StudentBo) BoFactory.getBoFactory().getBO(BoFactory.BOTypes.STUDENT);
    QueryBo queryBo = (QueryBo) BoFactory.getBoFactory().getBO(BoFactory.BOTypes.QUERY);



    public void initialize() throws SQLException, ClassNotFoundException, IOException {
        colStudentId.setCellValueFactory(new PropertyValueFactory("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colContact.setCellValueFactory(new PropertyValueFactory("contact"));
        colBirthday.setCellValueFactory(new PropertyValueFactory("birthday"));
        colGender.setCellValueFactory(new PropertyValueFactory("gender"));

        setStudents();
        btnSave.setDisable(true);
        btnDelete.setDisable(true);

        tblStudents.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> setDetails(newValue));
    }

    private void setDetails(Student student) {
        txtName.setText(student.getName());
        txtAddress.setText(student.getAddress());
        txtContact.setText(student.getContact());
        dateBirthDay.setValue(LocalDate.parse(student.getBirthday()));
        comboGender.setValue(student.getGender());
        btnDelete.setDisable(false);
    }

    private void setStudents() throws SQLException, ClassNotFoundException, IOException {
        ObservableList<Student> students = FXCollections.observableArrayList();
        ArrayList<Student> all = studentBo.getAll();

        for(Student student : all){
            students.add(student);
        }

        String [] gender = {"Male" , "Female"};
        ObservableList<String> genderList = FXCollections.observableArrayList(gender);
        comboGender.setItems(genderList);
        tblStudents.setItems(students);
    }

    public void deleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ?").showAndWait();

        if(buttonType.get().equals(ButtonType.OK)){
            Student student = tblStudents.getSelectionModel().getSelectedItem();

            queryBo.deleteReserveByStudentId(student.getStudentId());
            //first delete reservations
            studentBo.delete(student.getStudentId());
            new Alert(Alert.AlertType.CONFIRMATION,"Student Deleted !").show();
            tblStudents.getItems().remove(student);
            tblStudents.refresh();
        }
    }

    public void saveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        LocalDate birthDay = dateBirthDay.getValue();
        String gender = comboGender.getValue();
        if(btnSave.getText().equals("Save")){
            if(name == null || address == null || contact == null || gender == null || birthDay == null){
                new Alert(Alert.AlertType.WARNING,"Something went wrong!..").show();
            }else{
                String DOB = birthDay.toString();
                Student student = new Student(studentBo.generateNewID(), name, address, contact, DOB, gender);
                new Alert(Alert.AlertType.CONFIRMATION,"Successfully added student!..").show();
                studentBo.save(student);
                setStudents();

            }
            //update
        }else{
            if(name == null || address == null || contact == null || gender == null || birthDay == null){
                new Alert(Alert.AlertType.WARNING,"Something went wrong!..").show();
            }else{
                String DOB = birthDay.toString();
                Student student = tblStudents.getSelectionModel().getSelectedItem();
                student.setName(txtName.getText());
                student.setAddress(address);
                student.setContact(contact);
                student.setBirthday(DOB);
                student.setGender(gender);
                new Alert(Alert.AlertType.CONFIRMATION,"Successfully added student!..").show();
                studentBo.update(student);
                tblStudents.refresh();
            }
        }

    }

    public void backOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) studentManageContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainForm.fxml"))));
    }

    public void keyReleasedOnAction(KeyEvent keyEvent) {
        if(tblStudents.getSelectionModel().getSelectedItem() != null){
            btnSave.setText("Update");

        }else{

        }
        validate();
    }

    private Object validate() {

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
            btnSave.setDisable(false);
        }
    }

    private void setRed(TextField textField) {
        if(textField.getLength() > 0){
            textField.setStyle("-fx-border-color: #ff001b");
        }
    }

}
