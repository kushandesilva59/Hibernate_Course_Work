package Controller;

import BO.BoFactory;
import BO.Custom.Impl.QueryBoImpl;
import BO.Custom.Impl.StudentBoImpl;
import BO.Custom.QueryBo;
import BO.Custom.StudentBo;
import DAO.Custom.Impl.QueryDaoImpl;
import DAO.Custom.QueryDao;
import Entity.Student;
import TM.StudentPaymentTM;
import javafx.collections.ObservableList;
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
    public TableView <StudentPaymentTM>tblStudents;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colContact;
    public TableColumn colRoomId;
    public TableColumn colPayment;
    QueryBo queryBo = (QueryBo) BoFactory.getBoFactory().getBO(BoFactory.BOTypes.QUERY);


    public void initialize() throws IOException {
        colId.setCellValueFactory(new PropertyValueFactory("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory("studentName"));
        colContact.setCellValueFactory(new PropertyValueFactory("contact"));
        colRoomId.setCellValueFactory(new PropertyValueFactory("roomId"));
        colPayment.setCellValueFactory(new PropertyValueFactory("payment"));

        setDetails();
    }

    private void setDetails() throws IOException {
        ObservableList<StudentPaymentTM> toBePayStudents = queryBo.getToBePayStudents();
        tblStudents.setItems(toBePayStudents);
    }

    public void backOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) findStudentContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MainForm.fxml"))));
    }
}
