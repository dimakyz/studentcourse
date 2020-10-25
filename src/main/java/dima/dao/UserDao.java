package dima.dao;

import dima.model.User;

import java.util.UUID;

public interface UserDao extends GenericDAO<User, UUID> {

    boolean userNameExist(String username);

    boolean emailExist(String email);

    User findUserByLoginOrEmail(String username);

    User findUserByLogin(String name);
}
