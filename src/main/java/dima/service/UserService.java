package dima.service;

import dima.model.User;

import java.time.LocalDateTime;

/**
 * Сервис добавление Студента
 */
public interface UserService {

    //Добавление студента
    void addStudent(User user);

    //установка времени
    void setTime(LocalDateTime now);

}