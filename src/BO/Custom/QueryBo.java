package BO.Custom;

import BO.SuperBo;
import TM.StudentPaymentTM;
import Util.FactoryConfiguration;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;

public interface QueryBo extends SuperBo {
    public ObservableList<StudentPaymentTM> getToBePayStudents() throws IOException;

    public boolean deleteReserveByStudentId(String studentId) throws IOException;

    public boolean deleteReserveByRoomId(String roomId) throws IOException ;
}
