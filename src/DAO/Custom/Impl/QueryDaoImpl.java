package DAO.Custom.Impl;

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

public class QueryDaoImpl implements QueryDao {
    public ObservableList<StudentPaymentTM> getToBePayStudents() throws IOException {
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

      /*  ObservableList<StudentPaymentTM> students = FXCollections.observableArrayList();

        Session session = FactoryConfiguration.getInstance().getSession();
        List <StudentPaymentTM>list = session.createQuery("SELECT s.studentId,r.room_roomId,s.name,s.contact FROM Student s INNER JOIN Reserve r ON s.studentId = r.studentId").list();

        for(StudentPaymentTM tm : list){
            students.add(tm);
        }

        return students;*/
    }

    public boolean deleteReserveByStudentId(String studentId) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("DELETE FROM Reserve WHERE student.studentId =: id");
        query.setParameter("id",studentId);

        int i = query.executeUpdate();

        transaction.commit();
        session.close();
        if(i > 0){
            return true;
        }else {
            return false;
        }
    }

    public boolean deleteReserveByRoomId(String roomId) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Reserve WHERE room.roomId =: id");
        query.setParameter("id",roomId);

        int i = query.executeUpdate();

        transaction.commit();
        session.close();
        if(i > 0){
            return true;
        }else {
            return false;
        }
    }
}
