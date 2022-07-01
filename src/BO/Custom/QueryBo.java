package BO.Custom;

import BO.SuperBo;
import TM.StudentPaymentTM;
import Util.FactoryConfiguration;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;

public interface QueryBo extends SuperBo {
    public ObservableList<StudentPaymentTM> getToBePayStudents();

    public boolean deleteReserveByStudentId(String studentId);
}
