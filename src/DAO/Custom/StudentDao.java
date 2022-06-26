package DAO.Custom;

import DAO.CrudDao;
import Dto.ReserveDto;
import Dto.StudentDto;
import Entity.Student;
import Util.FactoryConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public interface StudentDao extends CrudDao<Student,String> {
    public ObservableList<String> getAllStudentIds();
}
