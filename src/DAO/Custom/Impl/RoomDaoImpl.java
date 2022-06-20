package DAO.Custom.Impl;

import DAO.Custom.RoomDao;
import Dto.RoomDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDaoImpl implements RoomDao {
    @Override
    public ArrayList<RoomDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(RoomDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(RoomDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public RoomDto search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
