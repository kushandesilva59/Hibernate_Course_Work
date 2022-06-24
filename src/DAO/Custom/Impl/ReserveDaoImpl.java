package DAO.Custom.Impl;

import DAO.Custom.ReserveDao;
import Dto.ReserveDto;
import Entity.Reserve;

import javax.xml.stream.FactoryConfigurationError;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReserveDaoImpl implements ReserveDao {

    @Override
    public ArrayList<Reserve> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Reserve dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Reserve dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Reserve search(String s) throws SQLException, ClassNotFoundException {
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
