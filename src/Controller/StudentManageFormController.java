package Controller;

import BO.Custom.Impl.StudentBoImpl;
import BO.Custom.StudentBo;
import Entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

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

    public void initialize() throws SQLException, ClassNotFoundException {
        colStudentId.setCellValueFactory(new PropertyValueFactory("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colContact.setCellValueFactory(new PropertyValueFactory("contact"));
        colBirthday.setCellValueFactory(new PropertyValueFactory("birthday"));
        colGender.setCellValueFactory(new PropertyValueFactory("gender"));

        setStudents();

        tblStudents.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> setDetails(newValue));
    }

    private void setDetails(Student student) {
        txtName.setText(student.getName());
        txtAddress.setText(student.getAddress());
        txtContact.setText(student.getContact());
        dateBirthDay.setValue(LocalDate.parse(student.getBirthday()));
        comboGender.setValue(student.getGender());
    }

    private void setStudents() throws SQLException, ClassNotFoundException {
        ObservableList<Student> students = FXCollections.observableArrayList();

        StudentBo studentBo = new StudentBoImpl();
        ArrayList<Student> all = studentBo.getAll();

        for(Student student : all){
            students.add(student);
        }

        String [] gender = {"Male" , "Female"};
        ObservableList<String> genderList = FXCollections.observableArrayList(gender);
        comboGender.setItems(genderList);
        tblStudents.setItems(students);
    }

    public void deleteOnAction(ActionEvent event) {

    }

    public void saveOnAction(ActionEvent event) {

    }

    public void backOnAction(ActionEvent event) {

    }
}
