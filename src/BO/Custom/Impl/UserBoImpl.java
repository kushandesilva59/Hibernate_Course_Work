package BO.Custom.Impl;

import BO.Custom.UserBo;
import DAO.Custom.Impl.UserDaoImpl;
import DAO.Custom.UserDao;
import Dto.UserDto;
import Entity.User;
import Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserBoImpl implements UserBo {
    UserDao userDao = new UserDaoImpl();

    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException {
        return userDao.getAll();
    }

    public boolean save(User user) throws SQLException, ClassNotFoundException {
        return userDao.save(user);
    }

    public boolean update(User user) throws SQLException, ClassNotFoundException {
        return userDao.update(user);
    }

    public User search(String userId) throws SQLException, ClassNotFoundException {
        return userDao.search(userId);
    }

    public boolean exist(String userId) throws SQLException, ClassNotFoundException {
        return userDao.exist(userId);
    }

    public boolean delete(String userId) throws SQLException, ClassNotFoundException {
        return userDao.delete(userId);
    }

    public String generateNewID() throws SQLException, ClassNotFoundException {
        return userDao.generateNewID();
    }

    public boolean checkOldPassword(User user,String id){
        return userDao.checkOldPassword(user,id);
    }

    public boolean passwordConfirmed(String newPassword,String confirmation){
        return userDao.passwordConfirmed(newPassword,confirmation);
    }

    public boolean changePassword(User user,String newPassword){
        return userDao.changePassword(user,newPassword);
    }
}
