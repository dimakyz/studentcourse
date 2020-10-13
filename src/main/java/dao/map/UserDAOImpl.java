package dao.map;

import dao.UserDao;
import model.User;

import java.util.HashMap;
import java.util.UUID;

public class UserDAOImpl extends AbstractDao<User, UUID> implements UserDao {

    public UserDAOImpl() {
        super(User.class, new HashMap<>());
    }

    @Override
    public boolean userNameExist(String username) {
        for (User el : elements.values()) {
            if (el.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean emailExist(String email) {
        for (User el : elements.values()) {
            if (el.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User findUserByLoginOrEmail(String username) {
        for (User el : elements.values()) {
            if (el.getUsername().equals(username) || el.getUsername().equals(username)) {
                return el;
            }
        }
        return null;
    }

    @Override
    public User findUserByLogin(String name) {
        for (User el : elements.values()) {
            if (el.getUsername().equals(name)) {
                return el;
            }
        }
        return null;
    }
}
