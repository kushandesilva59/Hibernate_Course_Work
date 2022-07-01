package BO.Custom.Impl;

import BO.Custom.ReserveBo;
import DAO.Custom.Impl.ReserveDaoImpl;
import DAO.Custom.ReserveDao;
import DAO.DaoFactory;
import Entity.Reserve;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReserveBoImpl implements ReserveBo {
    ReserveDao reserveDao = (ReserveDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.RESERVE);


    @Override
    public ArrayList<Reserve> getAll() throws SQLException, ClassNotFoundException, IOException {
       return reserveDao.getAll();
    }

    @Override
    public boolean save(Reserve reserve) throws SQLException, ClassNotFoundException, IOException {
        return reserveDao.save(reserve);
    }

    @Override
    public boolean update(Reserve reserve) throws SQLException, ClassNotFoundException, IOException {
        return reserveDao.update(reserve);
    }

    @Override
    public Reserve search(String reserveId) throws SQLException, ClassNotFoundException, IOException {
        return reserveDao.search(reserveId);
    }

    @Override
    public boolean exist(String reserveId) throws SQLException, ClassNotFoundException, IOException {
        return reserveDao.exist(reserveId);
    }

    @Override
    public boolean delete(String reserveId) throws SQLException, ClassNotFoundException, IOException {
        return reserveDao.delete(reserveId);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException, IOException {
        return reserveDao.generateNewID();
    }
}
