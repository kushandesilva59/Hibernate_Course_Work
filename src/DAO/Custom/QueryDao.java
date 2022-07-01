package DAO.Custom;

import Entity.Reserve;
import TM.StudentPaymentTM;
import Util.FactoryConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public interface QueryDao {
    public ObservableList<StudentPaymentTM> getToBePayStudents();

    public boolean deleteReserveByStudentId(String studentId);
}
