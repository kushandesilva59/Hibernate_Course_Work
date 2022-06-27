package DAO.Custom;

import DAO.CrudDao;
import Dto.UserDto;
import Entity.User;

public interface UserDao extends CrudDao<User,String> {
    public boolean checkOldPassword(User user,String id);
}
