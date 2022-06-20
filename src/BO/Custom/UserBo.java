package BO.Custom;

import Dto.UserDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBo {
    public ArrayList<UserDto> getAll() throws SQLException, ClassNotFoundException;

    public boolean save(UserDto dto) throws SQLException, ClassNotFoundException ;

    public boolean update(UserDto dto) throws SQLException, ClassNotFoundException ;

    public UserDto search(String userId) throws SQLException, ClassNotFoundException ;

    public boolean exist(String userId) throws SQLException, ClassNotFoundException ;

    public boolean delete(String userId) throws SQLException, ClassNotFoundException;

    public String generateNewID() throws SQLException, ClassNotFoundException;
}
