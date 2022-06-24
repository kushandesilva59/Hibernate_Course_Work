package BO.Custom.Impl;

import BO.Custom.ReserveBo;
import DAO.Custom.Impl.ReserveDaoImpl;
import DAO.Custom.ReserveDao;
import Dto.ReserveDto;
import Entity.Reserve;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReserveBoImpl implements ReserveBo {
    ReserveDao reserveDao = new ReserveDaoImpl();


    @Override
    public ArrayList<Reserve> getAll() throws SQLException, ClassNotFoundException {
       return reserveDao.getAll();
    }

    @Override
    public boolean save(Reserve reserve) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Reserve reserve) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ReserveDto search(String reserveId) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String reserveId) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String reserveId) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
