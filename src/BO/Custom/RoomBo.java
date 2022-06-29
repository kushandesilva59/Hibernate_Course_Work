package BO.Custom;

import BO.SuperBo;
import Dto.RoomDto;
import Entity.Room;
import Util.FactoryConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RoomBo extends SuperBo {
    public ArrayList<Room> getAll() throws SQLException, ClassNotFoundException;

    public boolean save(Room room) throws SQLException, ClassNotFoundException;

    public boolean update(Room room) throws SQLException, ClassNotFoundException;

    public Room search(String roomId) throws SQLException, ClassNotFoundException ;

    public boolean exist(String roomId) throws SQLException, ClassNotFoundException;

    public boolean delete(String roomId) throws SQLException, ClassNotFoundException ;

    public String generateNewID() throws SQLException, ClassNotFoundException;

    public void setRoomQty(String roomId);

    public ObservableList<Room> getAvailableRooms();
}
