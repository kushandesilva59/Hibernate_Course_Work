package BO;

import BO.Custom.Impl.ReserveBoImpl;
import BO.Custom.Impl.RoomBoImpl;
import BO.Custom.Impl.StudentBoImpl;
import BO.Custom.Impl.UserBoImpl;

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
                return new ReserveBoImpl(); // SuperBO bo =new CustomerBOImpl();
            case ROOM:
                return new  RoomBoImpl(); // SuperBO bo = new ItemBOImpl();
            case STUDENT:
                return new StudentBoImpl(); //SuperBO bo = new PurchaseOrderBOImpl();
            case USER:
                return new UserBoImpl(); //SuperBO bo = new PurchaseOrderBOImpl();
            default:
                return null;
        }
    }

    public enum BOTypes {
        RESERVE, ROOM, STUDENT,USER
    }
}
