package BO.Custom;

import BO.SuperBo;
import Entity.Reserve;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ReserveBo extends SuperBo {
    public ArrayList<Reserve> getAll() throws SQLException, ClassNotFoundException, IOException;

    public boolean save(Reserve reserve) throws SQLException, ClassNotFoundException, IOException;

    public boolean update(Reserve reserve) throws SQLException, ClassNotFoundException, IOException;

    public Reserve search(String reserveId) throws SQLException, ClassNotFoundException, IOException;

    public boolean exist(String reserveId) throws SQLException, ClassNotFoundException, IOException;

    public boolean delete(String reserveId) throws SQLException, ClassNotFoundException, IOException;

    public String generateNewID() throws SQLException, ClassNotFoundException, IOException;

}
