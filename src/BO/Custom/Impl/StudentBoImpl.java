package BO.Custom.Impl;

import BO.Custom.StudentBo;
import DAO.Custom.Impl.StudentDaoImpl;
import DAO.Custom.StudentDao;
import DAO.DaoFactory;
import Dto.StudentDto;
import Entity.Student;
import Util.FactoryConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBoImpl implements StudentBo {
    StudentDao studentDao = (StudentDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.STUDENT);

    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException, IOException {
        return studentDao.getAll();
    }

    @Override
    public boolean save(Student student) throws SQLException, ClassNotFoundException, IOException {
        return studentDao.save(student);
    }

    @Override
    public boolean update(Student student) throws SQLException, ClassNotFoundException, IOException {
        return studentDao.update(student);
    }

    @Override
    public Student search(String studentId) throws SQLException, ClassNotFoundException, IOException {
        return studentDao.search(studentId);
    }

    @Override
    public boolean exist(String studentId) throws SQLException, ClassNotFoundException, IOException {
        return studentDao.exist(studentId);
    }

    @Override
    public boolean delete(String studentId) throws SQLException, ClassNotFoundException, IOException {
        return studentDao.delete(studentId);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException, IOException {
        return studentDao.generateNewID();
    }
    public ObservableList<String> getAllStudentIds() throws IOException {
      return studentDao.getAllStudentIds();
    }
}
