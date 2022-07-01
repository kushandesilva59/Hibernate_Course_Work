package BO.Custom.Impl;

import BO.Custom.RoomBo;
import DAO.Custom.Impl.RoomDaoImpl;
import DAO.Custom.RoomDao;
import DAO.DaoFactory;
import Dto.RoomDto;
import Entity.Room;
import Util.FactoryConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomBoImpl implements RoomBo {
    RoomDao roomDao = (RoomDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.ROOM);

    @Override
    public ArrayList<Room> getAll() throws SQLException, ClassNotFoundException, IOException {
        return roomDao.getAll();
    }

    @Override
    public boolean save(Room room) throws SQLException, ClassNotFoundException, IOException {
        return roomDao.save(room);
    }

    @Override
    public boolean update(Room room) throws SQLException, ClassNotFoundException, IOException {
        return roomDao.update(room);
    }

    @Override
    public Room search(String roomId) throws SQLException, ClassNotFoundException, IOException {
        return roomDao.search(roomId);
    }

    @Override
    public boolean exist(String roomId) throws SQLException, ClassNotFoundException, IOException {
        return roomDao.exist(roomId);
    }

    @Override
    public boolean delete(String roomId) throws SQLException, ClassNotFoundException, IOException {
        return roomDao.delete(roomId);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException, IOException {
        return roomDao.generateNewID();
    }

    public void setRoomQty(String roomId) throws IOException {
       roomDao.setRoomQty(roomId);
    }

    public ObservableList<Room> getAvailableRooms() throws IOException {
        return roomDao.getAvailableRooms();
    }
}
