package BO.Custom;

import BO.SuperBo;
import Dto.RoomDto;
import Entity.Room;
import Util.FactoryConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RoomBo extends SuperBo {
    public ArrayList<Room> getAll() throws SQLException, ClassNotFoundException, IOException;

    public boolean save(Room room) throws SQLException, ClassNotFoundException, IOException;

    public boolean update(Room room) throws SQLException, ClassNotFoundException, IOException;

    public Room search(String roomId) throws SQLException, ClassNotFoundException, IOException;

    public boolean exist(String roomId) throws SQLException, ClassNotFoundException, IOException;

    public boolean delete(String roomId) throws SQLException, ClassNotFoundException, IOException;

    public String generateNewID() throws SQLException, ClassNotFoundException, IOException;

    public void setRoomQty(String roomId) throws IOException;

    public ObservableList<Room> getAvailableRooms() throws IOException;
}
