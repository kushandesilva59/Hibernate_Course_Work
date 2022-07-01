package BO;

import BO.Custom.Impl.*;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {
    }

    public static BoFactory getBoFactory() {
        if (boFactory == null) {
            boFactory = new BoFactory();
        }
        return boFactory;
    }

    public SuperBo getBO(BOTypes types) {
        switch (types) {
            case RESERVE:
                return new ReserveBoImpl();
            case ROOM:
                return new  RoomBoImpl();
            case STUDENT:
                return new StudentBoImpl();
            case USER:
                return new UserBoImpl();
            case QUERY:
                return new QueryBoImpl();
            default:
                return null;
        }
    }

    public enum BOTypes {
        RESERVE, ROOM, STUDENT,USER,QUERY;
    }
}
