package DAO.Custom.Impl;

import DAO.Custom.StudentDao;
import Dto.StudentDto;
import Entity.Student;
import Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {


    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException {
        ArrayList <Student> students = new ArrayList();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List <Student>from_student = session.createQuery("FROM Student ").list();
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
        return null;
    }
}
