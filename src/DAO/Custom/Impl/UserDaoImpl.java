package DAO.Custom.Impl;

import DAO.Custom.UserDao;
import Dto.UserDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao {
    @Override
    public ArrayList<UserDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(UserDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(UserDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public UserDto search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
