package BO.Custom;

import BO.SuperBo;
import Dto.StudentDto;
import Entity.Student;
import Util.FactoryConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface StudentBo extends SuperBo {
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException ;

    public boolean save(Student student) throws SQLException, ClassNotFoundException;

    public boolean update(Student student) throws SQLException, ClassNotFoundException;

    public Student search(String studentId) throws SQLException, ClassNotFoundException ;

    public boolean exist(String studentId) throws SQLException, ClassNotFoundException ;

    public boolean delete(String studentId) throws SQLException, ClassNotFoundException;

    public String generateNewID() throws SQLException, ClassNotFoundException ;

    public ObservableList<String> getAllStudentIds();
}
