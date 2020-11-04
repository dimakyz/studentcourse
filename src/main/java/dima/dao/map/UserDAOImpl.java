package dima.dao.map;

import dima.dao.UserDao;
import dima.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class UserDAOImpl extends AbstractDao<User, UUID> implements UserDao {

    public UserDAOImpl() {
        super(User.class, new HashMap<>());
    }

    //Проверка на имя
    @Override
    public boolean userNameExist(String username) {
        for (User el : elements.values()) {
            if (el.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    //Проверка на существование Email
    @Override
    public boolean emailExist(String email) {
        for (User el : elements.values()) {
            if (el.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    //Получение студента по имени
    @Override
    public User findStudentByName(String username) {
        for (User el : elements.values()) {
            if (el.getUsername().equals(username)) {
                return el;
            }
        }
        return null;
    }

    //Получение студента по имейл
    @Override
    public User findStudentByEmail(String email) {
        for (User el : elements.values()) {
            if (el.getEmail().equals(email)) {
                return el;
            }
        }
        return null;
    }
}