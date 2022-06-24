package BO.Custom;

import BO.SuperBo;
import Dto.RoomDto;
import Entity.Room;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomBo extends SuperBo {
    public ArrayList<Room> getAll() throws SQLException, ClassNotFoundException;

    public boolean save(Room room) throws SQLException, ClassNotFoundException;

    public boolean update(Room room) throws SQLException, ClassNotFoundException;

    public Room search(String roomId) throws SQLException, ClassNotFoundException ;

    public boolean exist(String roomId) throws SQLException, ClassNotFoundException;

    public boolean delete(String roomId) throws SQLException, ClassNotFoundException ;

    public String generateNewID() throws SQLException, ClassNotFoundException;
}
