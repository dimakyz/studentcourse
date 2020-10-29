package dima.service;

import dima.controller.dto.UserDto;
import dima.model.User;

import java.util.Set;

public interface RegistrationService {

    //Регистрация пользователя и создание ему UUID
    Set<User> regStudent(UserDto userDto);

    //Обновление имейла у пользователя по имени
    Set<User> updateStudent(String userName);

    //Получение пользователя по имени
    User getStudent(String userName);

    //Удаление пользователя по имени
    Set<User> deleteStudent(String userName);
}
