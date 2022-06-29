package DAO.Custom.Impl;

import DAO.Custom.ReserveDao;
import Entity.Reserve;
import Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReserveDaoImpl implements ReserveDao {

    @Override
    public ArrayList<Reserve> getAll() throws SQLException, ClassNotFoundException {
        ArrayList <Reserve> reserves = new ArrayList();
        Session session = FactoryConfiguration.getInstance().getSession();

        List <Reserve>from_reserve = session.createQuery("FROM Reserve ").list();
        while(from_reserve.isEmpty()){
           for(Reserve reserve : from_reserve){
               reserves.add(reserve);
           }
        }
        session.close();
        return reserves;
    }

    @Override
    public boolean save(Reserve reserve) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(reserve);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Reserve reserve) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(reserve);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Reserve search(String reserveId) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();

        Reserve reserve = session.find(Reserve.class, reserveId);
        session.close();
        return reserve;
    }

    @Override
    public boolean exist(String reserveId) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Reserve reserve = session.find(Reserve.class, reserveId);
        session.close();
        if(reserve != null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean delete(String reserveId) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.delete(reserveId);
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();

        Query query = session.createQuery("SELECT reserveId FROM Reserve ORDER BY reserveId DESC").setMaxResults(1);
        List list = query.list();
        session.close();

        String newUserId = "";

        String lastUserId = list.toString();
        String[] split = lastUserId.split("[A-z]");
        int integer = 0;
        if(split.length > 0){
             integer = Integer.valueOf(split[3]);
            ++integer;
        }


        if(!list.isEmpty()){
            if (integer>=100) {
                newUserId = "RE" + String.valueOf(integer) ;
            }else if(integer>=10){
                newUserId = "RE0" + String.valueOf(integer);
            }else{
                newUserId = "RE00" + String.valueOf(integer);
            }
            return newUserId;

        }else{
            return "RE001";
        }
    }
}
