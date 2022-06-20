package BO.Custom;

import Dto.ReserveDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReserveBo {
    public ArrayList<ReserveDto> getAll() throws SQLException, ClassNotFoundException;

    public boolean save(ReserveDto dto) throws SQLException, ClassNotFoundException;

    public boolean update(ReserveDto dto) throws SQLException, ClassNotFoundException;

    public ReserveDto search(String reserveId) throws SQLException, ClassNotFoundException ;

    public boolean exist(String reserveId) throws SQLException, ClassNotFoundException;

    public boolean delete(String reserveId) throws SQLException, ClassNotFoundException;

    public String generateNewID() throws SQLException, ClassNotFoundException;

}
