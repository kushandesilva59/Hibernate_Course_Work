package DAO.Custom;

import Entity.Reserve;
import TM.StudentPaymentTM;
import Util.FactoryConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public interface QueryDao {
    public ObservableList<StudentPaymentTM> getToBePayStudents() throws IOException;

    public boolean deleteReserveByStudentId(String studentId) throws IOException;
}
