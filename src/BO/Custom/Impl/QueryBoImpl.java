package BO.Custom.Impl;

import BO.Custom.QueryBo;
import DAO.Custom.Impl.QueryDaoImpl;
import DAO.Custom.QueryDao;
import Entity.Reserve;
import TM.StudentPaymentTM;
import Util.FactoryConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class QueryBoImpl implements QueryBo {
    QueryDao queryDao = new QueryDaoImpl();

    public ObservableList<StudentPaymentTM> getToBePayStudents() throws IOException {
       return queryDao.getToBePayStudents();
    }

    public boolean deleteReserveByStudentId(String studentId) throws IOException {
        return queryDao.deleteReserveByStudentId(studentId);
    }

    public boolean deleteReserveByRoomId(String roomId) throws IOException {
        return queryDao.deleteReserveByRoomId(roomId);
    }
}
