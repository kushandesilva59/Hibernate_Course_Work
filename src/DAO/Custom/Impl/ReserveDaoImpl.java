package DAO.Custom.Impl;

import DAO.Custom.ReserveDao;
import Dto.ReserveDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReserveDaoImpl implements ReserveDao {
    @Override
    public ArrayList<ReserveDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(ReserveDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(ReserveDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ReserveDto search(String s) throws SQLException, ClassNotFoundException {
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
