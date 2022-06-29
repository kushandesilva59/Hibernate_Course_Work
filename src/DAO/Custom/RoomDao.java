package DAO.Custom;

import DAO.CrudDao;
import Dto.ReserveDto;
import Dto.RoomDto;
import Entity.Room;
import Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public interface RoomDao extends CrudDao<Room,String> {
    public void setRoomQty(String roomId);
}
