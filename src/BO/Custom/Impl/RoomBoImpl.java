package BO.Custom.Impl;

import BO.Custom.RoomBo;
import DAO.Custom.Impl.RoomDaoImpl;
import DAO.Custom.RoomDao;
import Dto.RoomDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class RoomBoImpl implements RoomBo {
    RoomDao roomDao = new RoomDaoImpl();

    public ArrayList<RoomDto> getAll() throws SQLException, ClassNotFoundException {
        return roomDao.getAll();
    }

    public boolean save(RoomDto dto) throws SQLException, ClassNotFoundException {
        return roomDao.save(dto);
    }

    public boolean update(RoomDto dto) throws SQLException, ClassNotFoundException {
        return roomDao.update(dto);
    }

    public RoomDto search(String roomId) throws SQLException, ClassNotFoundException {
        return roomDao.search(roomId);
    }

    public boolean exist(String roomId) throws SQLException, ClassNotFoundException {
        return roomDao.exist(roomId);
    }

    public boolean delete(String roomId) throws SQLException, ClassNotFoundException {
        return roomDao.delete(roomId);
    }

    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
