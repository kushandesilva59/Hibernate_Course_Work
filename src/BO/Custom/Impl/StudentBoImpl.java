package BO.Custom.Impl;

import BO.Custom.StudentBo;
import DAO.Custom.Impl.StudentDaoImpl;
import DAO.Custom.StudentDao;
import Dto.StudentDto;
import Entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentBoImpl implements StudentBo {
    StudentDao studentDao = new StudentDaoImpl();

    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Student student) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Student student) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public StudentDto search(String studentId) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String studentId) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String studentId) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
