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
        return studentDao.getAll();
    }

    @Override
    public boolean save(Student student) throws SQLException, ClassNotFoundException {
        return studentDao.save(student);
    }

    @Override
    public boolean update(Student student) throws SQLException, ClassNotFoundException {
        return studentDao.update(student);
    }

    @Override
    public Student search(String studentId) throws SQLException, ClassNotFoundException {
        return studentDao.search(studentId);
    }

    @Override
    public boolean exist(String studentId) throws SQLException, ClassNotFoundException {
        return studentDao.exist(studentId);
    }

    @Override
    public boolean delete(String studentId) throws SQLException, ClassNotFoundException {
        return studentDao.delete(studentId);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return studentDao.generateNewID();
    }
}
