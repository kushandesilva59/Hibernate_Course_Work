package Controller;

import BO.Custom.Impl.StudentBoImpl;
import BO.Custom.StudentBo;
import Entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FindStudentsFormController {
    public AnchorPane findStudentContext;
    public TableView <Student>tblStudents;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colBirthday;

    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colContact.setCellValueFactory(new PropertyValueFactory("contact"));
        colBirthday.setCellValueFactory(new PropertyValueFactory("birthday"));

        setDetails();
    }

    private void setDetails() {
        StudentBo studentBo = new StudentBoImpl();
    }

    public void backOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) findStudentContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainForm.fxml"))));
    }
}
