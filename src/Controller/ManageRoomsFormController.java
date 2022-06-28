package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageRoomsFormController {
    public AnchorPane manageRoomsContext;

    public void addRoomOnAction(ActionEvent event) throws IOException {
        loadUi("AddRoomForm");
    }

    public void updateRoomOnAction(ActionEvent event) {

    }

    public void backOnAction(ActionEvent event) throws IOException {
        loadUi("MainForm");
    }

    public void loadUi(String location) throws IOException {
        Stage stage = (Stage) manageRoomsContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
