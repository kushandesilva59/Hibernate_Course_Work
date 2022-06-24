package DAO.Custom.Impl;

import DAO.Custom.UserDao;
import Dto.UserDto;
import Entity.User;
import Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException {
        ArrayList <User> users = new ArrayList();

        Session session = FactoryConfiguration.getInstance().getSession();

        List <User>list = session.createQuery(" FROM User ").list();
        while(list.isEmpty()){
            for(User user : list){
                users.add(user);
            }
        }


        session.close();
        return users;
    }

    @Override
    public boolean save(User user) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(User user) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(user);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public User search(String userId) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();

        User user = session.find(User.class, userId);

        session.close();
        return user;
    }

    @Override
    public boolean exist(String userId) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String userId) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        User load = session.load(User.class, userId);
        session.delete(load);

        transaction.commit();
        session.close();

        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();

        Query query = session.createQuery("SELECT userId FROM User ORDER BY userId DESC LIMIT 1 ");
        List list = query.list();
        System.out.println(list);
        session.close();

        String newVersion;

        String version = list.toString();
        int i = (Integer.parseInt(version.substring(1, version.length()))+1);

        if(!list.isEmpty()){
            if (i==100) {
                newVersion = "U0" +  i;
            }else {
                newVersion = "U00" + i;
            }
            return newVersion;

        }else{
            return "U001";
        }
    }
}
