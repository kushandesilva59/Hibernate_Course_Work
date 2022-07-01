package DAO;

import DAO.Custom.Impl.*;
import DAO.Custom.SuperDao;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }


    public static DaoFactory getDaoFactory() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }


    public enum DAOTypes {
        RESERVE, STUDENT, ROOM, USER,QUERY
    }


    public SuperDao getDAO(DAOTypes types) {
        switch (types) {
            case RESERVE:
                return new ReserveDaoImpl();
            case STUDENT:
                return new StudentDaoImpl();
            case ROOM:
                return  new RoomDaoImpl();
            case USER:
                return new UserDaoImpl();
            case QUERY:
                return new QueryDaoImpl();
            default:
                return null;
        }
    }
}
