package DAO.Custom.Impl;

import DAO.Custom.StudentDao;
import Dto.StudentDto;
import Entity.Student;
import Util.FactoryConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException {
        ArrayList <Student> students = new ArrayList();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List <Student> from_student = session.createQuery("FROM Student ").list();
        while(from_student.isEmpty()){
            for(Student student : from_student){
               students.add(student);
            }
        }

        transaction.commit();
        session.close();
        return students;
    }

    @Override
    public boolean save(Student student) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student student) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(student);

        transaction.commit();
        session.close();
        return true;    }

    @Override
    public Student search(String studentId) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Student student = session.get(Student.class, studentId);
        session.close();
        return student;
    }

    @Override
    public boolean exist(String studentId) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Student student = session.get(Student.class, studentId);
        session.close();
        if(student != null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean delete(String studentId) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.load(Student.class, studentId);
        session.delete(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();

        Query query = session.createQuery("SELECT studentId FROM Student ORDER BY studentId DESC").setMaxResults(1);
        List list = query.list();
        session.close();

        String newUserId = "";

        String lastUserId = list.toString();
        String[] split = lastUserId.split("[A-z]");
        Integer integer = Integer.valueOf(split[2]);
        ++integer;

        if(!list.isEmpty()){
            if (integer>=100) {
                newUserId = "S" + String.valueOf(integer) ;
            }else if(integer>=10){
                newUserId = "S0" + String.valueOf(integer);
            }else{
                newUserId = "S00" + String.valueOf(integer);
            }
            return newUserId;

        }else{
            return "S001";
        }
    }

    public ObservableList<String> getAllStudentIds(){
        ObservableList <String> studentIds = FXCollections.observableArrayList();

        Session session = FactoryConfiguration.getInstance().getSession();

        List <String> from_student = session.createQuery("SELECT studentId FROM Student ").list();
            for(String studentId : from_student){
                studentIds.add(studentId);
            }
        session.close();
        return studentIds;
    }
}
