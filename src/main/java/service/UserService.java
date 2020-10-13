package service;

import model.User;

import java.time.LocalDateTime;

public interface UserService {
    void addStudent(User user);

    void setTime(LocalDateTime now);

}
