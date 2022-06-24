package BO.Custom;

import BO.SuperBo;
import Dto.UserDto;
import Entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBo extends SuperBo {
    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException;

    public boolean save(User user) throws SQLException, ClassNotFoundException ;

    public boolean update(User user) throws SQLException, ClassNotFoundException ;

    public User search(String userId) throws SQLException, ClassNotFoundException ;

    public boolean exist(String userId) throws SQLException, ClassNotFoundException ;

    public boolean delete(String userId) throws SQLException, ClassNotFoundException;

    public String generateNewID() throws SQLException, ClassNotFoundException;
}
