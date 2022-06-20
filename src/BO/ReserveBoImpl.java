package BO;

import DAO.Custom.Impl.ReserveDaoImpl;
import DAO.Custom.ReserveDao;
import Dto.ReserveDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReserveBoImpl {
    ReserveDao reserveDao = new ReserveDaoImpl();

    public ArrayList<ReserveDto> getAll() throws SQLException, ClassNotFoundException {
        return reserveDao.getAll();
    }

    public boolean save(ReserveDto dto) throws SQLException, ClassNotFoundException {
        return reserveDao.save(dto);
    }

    public boolean update(ReserveDto dto) throws SQLException, ClassNotFoundException {
        return reserveDao.update(dto);
    }

    public ReserveDto search(String reserveId) throws SQLException, ClassNotFoundException {
        return reserveDao.search(reserveId);
    }

    public boolean exist(String reserveId) throws SQLException, ClassNotFoundException {
        return reserveDao.exist(reserveId);
    }

    public boolean delete(String reserveId) throws SQLException, ClassNotFoundException {
        return reserveDao.delete(reserveId);
    }

    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
