package DAO.Custom.Impl;

import DAO.Custom.StudentDao;
import Dto.StudentDto;
import Entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDaoImpl implements StudentDao {


    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Student dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Student dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Student search(String s) throws SQLException, ClassNotFoundException {
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
