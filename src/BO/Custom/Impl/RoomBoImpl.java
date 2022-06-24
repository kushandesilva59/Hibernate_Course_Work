package BO.Custom.Impl;

import BO.Custom.RoomBo;
import DAO.Custom.Impl.RoomDaoImpl;
import DAO.Custom.RoomDao;
import Dto.RoomDto;
import Entity.Room;

import java.sql.SQLException;
import java.util.ArrayList;

public class RoomBoImpl implements RoomBo {
    RoomDao roomDao = new RoomDaoImpl();


    @Override
    public ArrayList<Room> getAll() throws SQLException, ClassNotFoundException {
        roomDao.
    }

    @Override
    public boolean save(Room room) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Room room) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public RoomDto search(String roomId) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String roomId) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String roomId) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
