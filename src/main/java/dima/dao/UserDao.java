package dima.dao;

import dima.model.User;

import java.util.UUID;

public interface UserDao extends GenericDAO<User, UUID> {

    //Проверка на существование студента по имени
    boolean userNameExist(String username);

    //Проверка на существование Email
    boolean emailExist(String email);

    //Получение студента по имени
    User findStudentByName(String username);

    //Получение студента по имейл
    User findStudentByEmail(String name);

}
