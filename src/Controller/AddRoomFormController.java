package Controller;

import Util.FactoryConfiguration;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class AddRoomFormController {
    public AnchorPane addRoomContext;
    public TextField txtType;
    public TextField txtKeyMoney;
    public TextField txtQty;
    public Button btnAdd;

    public void initialize(){
        btnAdd.setDisable(true);
    }

    public void addOnAction(ActionEvent event) {
        Session session = FactoryConfiguration.getInstance().getSession();

    }

    public void cancelOnAction(ActionEvent event) throws IOException {
        loadUi("MainForm");
    }

    public void keyReleasedOnAction(KeyEvent keyEvent) {
        validate();
        if(txtType.getText() != null && txtKeyMoney.getText() != null && txtQty.getText() != null){
            btnAdd.setDisable(false);
        }
    }

    private Object validate() {
        LinkedHashMap<TextField, Pattern> map = new LinkedHashMap<>();

        Pattern typePattern = Pattern.compile("^[A-z 0-9]{3,15}$");
        Pattern keyMoneyPattern = Pattern.compile("^[0-9]{3,20}$");
        Pattern qtyPattern = Pattern.compile("^[0-9]{1,100}$");

        map.put(txtType,typePattern);
        map.put(txtKeyMoney,keyMoneyPattern);
        map.put(txtQty,qtyPattern);

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

    public void loadUi(String location) throws IOException {
        Stage stage = (Stage) addRoomContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
