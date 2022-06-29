package DAO.Custom.Impl;

import Entity.Reserve;
import Entity.Student;
import TM.StudentPaymentTM;
import Util.FactoryConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class QueryDaoImpl {
    public ObservableList<StudentPaymentTM> getToBePayStudents(){
        ObservableList<StudentPaymentTM> students = FXCollections.observableArrayList();

        Session session = FactoryConfiguration.getInstance().getSession();
        List <Reserve>list = session.createQuery("FROM Reserve WHERE status = 'To be pay'").list();

        for(Reserve reserve : list){
            String studentId = reserve.getStudent().getStudentId();
            String roomId = reserve.getRoom().getRoomId();
            String name = reserve.getStudent().getName();
            String contact = reserve.getStudent().getContact();
            double keyMoney = reserve.getRoom().getKeyMoney();

            students.add(new StudentPaymentTM(studentId,name,roomId,contact,keyMoney));
        }
        return students;
    }
}
