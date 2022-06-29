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

import java.util.List;

public class QueryBoImpl implements QueryBo {
    QueryDao queryDao = new QueryDaoImpl();

    public ObservableList<StudentPaymentTM> getToBePayStudents(){
       return queryDao.getToBePayStudents();
    }
}
