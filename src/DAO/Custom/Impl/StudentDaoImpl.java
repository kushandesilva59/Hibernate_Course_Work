package DAO.Custom.Impl;

import DAO.Custom.StudentDao;
import Dto.StudentDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDaoImpl implements StudentDao {
    @Override
    public ArrayList<StudentDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(StudentDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(StudentDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public StudentDto search(String s) throws SQLException, ClassNotFoundException {
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