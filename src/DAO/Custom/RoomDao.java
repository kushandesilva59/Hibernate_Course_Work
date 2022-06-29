package DAO.Custom;

import DAO.CrudDao;
import Dto.ReserveDto;
import Dto.RoomDto;
import Entity.Room;
import Util.FactoryConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public interface RoomDao extends CrudDao<Room,String> {
    public void setRoomQty(String roomId);

    public ObservableList<Room> getAvailableRooms();
}
