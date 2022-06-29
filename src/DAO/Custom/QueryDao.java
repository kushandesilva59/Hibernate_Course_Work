package DAO.Custom;

import Entity.Reserve;
import TM.StudentPaymentTM;
import Util.FactoryConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import java.util.List;

public interface QueryDao {
    public ObservableList<StudentPaymentTM> getToBePayStudents();
}
