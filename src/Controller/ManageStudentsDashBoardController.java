package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageStudentsDashBoardController {
    public AnchorPane manageStudentDashBoard;

    public void toBePayStudentsOnAction(ActionEvent event) throws IOException {
        loadUi("FindStudentsForm");
    }

    public void manageStudentsOnAction(ActionEvent event) throws IOException {
        loadUi("StudentManageForm");
    }

    public void backOnAction(ActionEvent event) throws IOException {
        loadUi("ManageStudentsDashBoard");
    }

    public void loadUi(String location) throws IOException {
        Stage stage = (Stage) manageStudentDashBoard.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }

}
