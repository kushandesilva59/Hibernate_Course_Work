package BO.Custom.Impl;

import BO.Custom.UserBo;
import DAO.Custom.Impl.UserDaoImpl;
import DAO.Custom.UserDao;
import Dto.UserDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserBoImpl implements UserBo {
    UserDao userDao = new UserDaoImpl();

    public ArrayList<UserDto> getAll() throws SQLException, ClassNotFoundException {
        return userDao.getAll();
    }

    public boolean save(UserDto dto) throws SQLException, ClassNotFoundException {
        return userDao.save(dto);
    }

    public boolean update(UserDto dto) throws SQLException, ClassNotFoundException {
        return userDao.update(dto);
    }

    public UserDto search(String userId) throws SQLException, ClassNotFoundException {
        return userDao.search(userId);
    }

    public boolean exist(String userId) throws SQLException, ClassNotFoundException {
        return userDao.exist(userId);
    }

    public boolean delete(String userId) throws SQLException, ClassNotFoundException {
        return userDao.delete(userId);
    }

    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
