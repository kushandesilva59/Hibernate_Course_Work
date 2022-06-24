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
        return reserveDao.save(reserve);
    }

    @Override
    public boolean update(Reserve reserve) throws SQLException, ClassNotFoundException {
        return reserveDao.update(reserve);
    }

    @Override
    public Reserve search(String reserveId) throws SQLException, ClassNotFoundException {
        return reserveDao.search(reserveId);
    }

    @Override
    public boolean exist(String reserveId) throws SQLException, ClassNotFoundException {
        return reserveDao.exist(reserveId);
    }

    @Override
    public boolean delete(String reserveId) throws SQLException, ClassNotFoundException {
        return reserveDao.delete(reserveId);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return reserveDao.generateNewID();
    }
}
