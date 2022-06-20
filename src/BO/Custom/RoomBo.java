package BO.Custom;

import Dto.RoomDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomBo {
    public ArrayList<RoomDto> getAll() throws SQLException, ClassNotFoundException;

    public boolean save(RoomDto dto) throws SQLException, ClassNotFoundException;

    public boolean update(RoomDto dto) throws SQLException, ClassNotFoundException;

    public RoomDto search(String roomId) throws SQLException, ClassNotFoundException ;

    public boolean exist(String roomId) throws SQLException, ClassNotFoundException;

    public boolean delete(String roomId) throws SQLException, ClassNotFoundException ;

    public String generateNewID() throws SQLException, ClassNotFoundException;
}
