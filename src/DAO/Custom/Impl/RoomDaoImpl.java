package DAO.Custom.Impl;

import DAO.Custom.RoomDao;
import Dto.RoomDto;
import Entity.Room;
import Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDao {

    @Override
    public ArrayList<Room> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Room> rooms = new ArrayList<>();

        Session session = FactoryConfiguration.getInstance().getSession();
        List <Room>from_room = session.createQuery("FROM Room ").list();
            for(Room room : from_room){
                rooms.add(room);
            }

        session.close();
        return rooms;
    }

    @Override
    public boolean save(Room room) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(room);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Room room) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(room);

        transaction.commit();
        session.close();
        return true;    }

    @Override
    public Room search(String roomId) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Room room = session.find(Room.class, roomId);
        session.close();
        return room;
    }

    @Override
    public boolean exist(String roomId) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Room room = session.find(Room.class, roomId);
        session.close();
        if(room != null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean delete(String roomId) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Room room = session.load(Room.class, roomId);
        session.delete(room);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();

        Query query = session.createQuery("SELECT roomId FROM Room ORDER BY roomId DESC").setMaxResults(1);
        List list = query.list();
        session.close();

        String newUserId = "";

        String lastUserId = list.toString();
        String[] split = lastUserId.split("[A-z]");
        Integer integer = Integer.valueOf(split[2]);
        ++integer;

        if(!list.isEmpty()){
            if (integer>=100) {
                newUserId = "R" + String.valueOf(integer) ;
            }else if(integer>=10){
                newUserId = "R0" + String.valueOf(integer);
            }else{
                newUserId = "R00" + String.valueOf(integer);
            }
            return newUserId;

        }else{
            return "R001";
        }
    }
}
