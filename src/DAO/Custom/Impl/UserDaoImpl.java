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
        Session session = FactoryConfiguration.getInstance().getSession();

        User user = session.find(User.class, userId);
        session.close();
        if(user != null){
            return true;
        }else {
            return false;
        }
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

        Query query = session.createQuery("SELECT userId FROM User ORDER BY userId DESC").setMaxResults(1);
        List list = query.list();
        session.close();

        String newUserId = "";

        String lastUserId = list.toString();
        String[] split = lastUserId.split("[A-z]");
        Integer integer = Integer.valueOf(split[2]);
        ++integer;

        if(!list.isEmpty()){
            if (integer>=100) {
                newUserId = "U" + String.valueOf(integer) ;
            }else if(integer>=10){
                newUserId = "U0" + String.valueOf(integer);
            }else{
                newUserId = "U00" + String.valueOf(integer);
            }
            return newUserId;

        }else{
            return "U001";
        }
    }

    public boolean checkOldPassword(User user,String id){
        if(user.getPassword().equals(id)){
            return true;
        }else{
            return false;
        }
    }
}
