package Controller;

import BO.Custom.Impl.ReserveBoImpl;
import BO.Custom.Impl.RoomBoImpl;
import BO.Custom.Impl.StudentBoImpl;
import BO.Custom.ReserveBo;
import BO.Custom.RoomBo;
import BO.Custom.StudentBo;
import Entity.Reserve;
import Entity.Room;
import Entity.Student;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;

public class MakeReservationFormController {

    public AnchorPane makeReservationContext;
    public ComboBox <String>comboRooms;
    public Label lblDate;
    public ComboBox <String>comboStudentIds;
    public TextField txtStudentName;
    public TextField txtStudentBDay;
    public TextField txtStudentContact;
    public TextField txtStudentAddress;
    public TextField txtRoomKeyMoney;
    public TextField txtRoomQTY;
    public TextField txtRoomType;
    public RadioButton radioKeyRental;
    public Button btnReserve;
    public Label lblResId;


    RoomBo roomBo = new RoomBoImpl();
    StudentBo studentBo = new StudentBoImpl();
    ReserveBo reserveBo = new ReserveBoImpl();


    public void initialize() throws SQLException, ClassNotFoundException {
        setResId();
        btnReserve.setDisable(true);
        setDate();
        setEditableTextFields();
        loadRooms();
        loadStudentIds();
        comboStudentIds.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            try {
                if(!comboRooms.getSelectionModel().isEmpty()){
                    btnReserve.setDisable(false);
                }
                setStudentDetails(newValue);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        comboRooms.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                setRoomDetails(newValue);
                if(!comboStudentIds.getSelectionModel().isEmpty()){
                    btnReserve.setDisable(false);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    private void setDate() {
            LocalDate currentDate = LocalDate.now();
            lblDate.setText(currentDate.getYear()+ "-" + currentDate.getMonthValue() + "-" + currentDate.getDayOfMonth());
    }

    private void setRoomDetails(String roomId) throws SQLException, ClassNotFoundException {
        Room room = roomBo.search(roomId);
        txtRoomType.setText(room.getType());
        txtRoomKeyMoney.setText("Rs."+String.valueOf(room.getKeyMoney()));
        txtRoomQTY.setText(String.valueOf(room.getQty()));
    }

    private void setStudentDetails(String studentId) throws SQLException, ClassNotFoundException {
        Student student = studentBo.search(studentId);
        txtStudentName.setText(student.getName());
        txtStudentAddress.setText(student.getAddress());
        txtStudentContact.setText(student.getContact());
        txtStudentBDay.setText(student.getBirthday());
    }

    private void loadStudentIds() {
        ObservableList<String> allStudentIds = studentBo.getAllStudentIds();
        comboStudentIds.setItems(allStudentIds);
    }

    private void loadRooms(){
        ObservableList <String> roomIds = FXCollections.observableArrayList();
        ObservableList<Room> availableRooms = roomBo.getAvailableRooms();

        for(Room room : availableRooms){
            roomIds.add(room.getRoomId());
        }

        comboRooms.setItems(roomIds);
    }

    public void addNewStudentOnAction(ActionEvent event) throws IOException {
        loadUi("AddNewStudentForm");
    }

    public void reserveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        String studentId = comboStudentIds.getValue();
        Student student = studentBo.search(studentId);

        String roomId = comboRooms.getValue();
        Room room = roomBo.search(roomId);

        String status = "To be pay";
        if(radioKeyRental.isSelected()){
            status = "Payed";
        }
        Reserve reserve = new Reserve();
        reserve.setReserveId(lblResId.getText());
        reserve.setDate(lblDate.getText());
        reserve.setStatus(status);
        reserve.setStudent(student);
        reserve.setRoom(room);
        reserveBo.save(reserve);

        room.getReserveList().add(reserve);
        student.getReserveList().add(reserve);
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION, "Reservation success!..").showAndWait();
        if(buttonType.get().equals(ButtonType.OK)){
            roomBo.setRoomQty(roomId);
            studentBo.update(student);
            loadUi("MakeReservationForm");
        }
    }

    public void cancelOnAction(ActionEvent event) throws IOException {
        loadUi("MainForm");
    }

    public void loadUi(String location) throws IOException {
        Stage stage = (Stage) makeReservationContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }

    public void setResId() throws SQLException, ClassNotFoundException {
        ReserveBoImpl reserveBo = new ReserveBoImpl();
        String reserveId = reserveBo.generateNewID();
        lblResId.setText(reserveId);
    }

    public void setEditableTextFields(){
        txtStudentName.setEditable(false);
        txtStudentAddress.setEditable(false);
        txtStudentContact.setEditable(false);
        txtStudentBDay.setEditable(false);
        txtRoomType.setEditable(false);
        txtRoomKeyMoney.setEditable(false);
        txtRoomQTY.setEditable(false);
    }
}
