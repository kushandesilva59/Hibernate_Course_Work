package DAO;


import DAO.Custom.SuperDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDao <T,ID> extends SuperDao {
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException, IOException;

    boolean save(T dto) throws SQLException, ClassNotFoundException, IOException;

    boolean update(T dto) throws SQLException, ClassNotFoundException, IOException;

    T search(ID id) throws SQLException, ClassNotFoundException, IOException;

    boolean exist(ID id) throws SQLException, ClassNotFoundException, IOException;

    boolean delete(ID id) throws SQLException, ClassNotFoundException, IOException;

    String generateNewID() throws SQLException, ClassNotFoundException, IOException;
}
