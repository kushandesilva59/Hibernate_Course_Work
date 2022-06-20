package BO.Custom.Impl;

import BO.Custom.StudentBo;
import DAO.Custom.Impl.StudentDaoImpl;
import DAO.Custom.StudentDao;
import Dto.StudentDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentBoImpl implements StudentBo {
    StudentDao studentDao = new StudentDaoImpl();

    public ArrayList<StudentDto> getAll() throws SQLException, ClassNotFoundException {
        return studentDao.getAll();
    }

    public boolean save(StudentDto dto) throws SQLException, ClassNotFoundException {
        return studentDao.save(dto);
    }

    public boolean update(StudentDto dto) throws SQLException, ClassNotFoundException {
        return studentDao.update(dto);
    }

    public StudentDto search(String studentId) throws SQLException, ClassNotFoundException {
        return studentDao.search(studentId);
    }

    public boolean exist(String studentId) throws SQLException, ClassNotFoundException {
        return studentDao.exist(studentId);
    }

    public boolean delete(String studentId) throws SQLException, ClassNotFoundException {
        return studentDao.delete(studentId);
    }

    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
