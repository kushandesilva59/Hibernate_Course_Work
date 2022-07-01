package Controller;

import Entity.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

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

    public void initialize(){
        
    }

    public void deleteOnAction(ActionEvent event) {
    }

    public void saveOnAction(ActionEvent event) {
    }

    public void backOnAction(ActionEvent event) {

    }
}
