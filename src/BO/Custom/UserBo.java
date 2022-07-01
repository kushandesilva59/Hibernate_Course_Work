package BO.Custom;

import BO.SuperBo;
import Dto.UserDto;
import Entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBo extends SuperBo {
    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException, IOException;

    public boolean save(User user) throws SQLException, ClassNotFoundException, IOException;

    public boolean update(User user) throws SQLException, ClassNotFoundException, IOException;

    public User search(String userId) throws SQLException, ClassNotFoundException, IOException;

    public boolean exist(String userId) throws SQLException, ClassNotFoundException, IOException;

    public boolean delete(String userId) throws SQLException, ClassNotFoundException, IOException;

    public String generateNewID() throws SQLException, ClassNotFoundException, IOException;

    public boolean checkOldPassword(User user,String id);

    public boolean passwordConfirmed(String newPassword,String confirmation);

    public boolean changePassword(User user,String newPassword) throws IOException;
}
