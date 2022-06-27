package BO.Custom;

import BO.SuperBo;
import Entity.Reserve;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReserveBo extends SuperBo {
    public ArrayList<Reserve> getAll() throws SQLException, ClassNotFoundException;

    public boolean save(Reserve reserve) throws SQLException, ClassNotFoundException;

    public boolean update(Reserve reserve) throws SQLException, ClassNotFoundException;

    public Reserve search(String reserveId) throws SQLException, ClassNotFoundException ;

    public boolean exist(String reserveId) throws SQLException, ClassNotFoundException;

    public boolean delete(String reserveId) throws SQLException, ClassNotFoundException;

    public String generateNewID() throws SQLException, ClassNotFoundException;

}
