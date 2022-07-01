package DAO.Custom;

import DAO.CrudDao;
import Dto.UserDto;
import Entity.User;
import Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;

public interface UserDao extends CrudDao<User,String> {
    public boolean checkOldPassword(User user,String id);

    public boolean passwordConfirmed(String newPassword,String confirmation);

    public boolean changePassword(User user,String newPassword) throws IOException;
}
