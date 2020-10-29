package dima.controller;

import dima.model.User;
import dima.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static dima.service.RegServiceImpl.users;

@RestController
@RequestMapping(value = "/api")
public class FirstController {

    private RegistrationService registrationService;

    @Autowired
    public FirstController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    //Get запрос Получение списка всех зарегистрированных пользователей
    @RequestMapping(value = "/first")
    public Set<User> sayHello() {
        return users;
    }

    //Get запрос Получение студента по имени
    @PostMapping
    @RequestMapping(value = "/find")
    public User getStudentByName(@RequestBody String userName) {
        return registrationService.getStudent(userName);
    }

    //Put запрос Обновление email у пользователя по имени и получение списка всех зарегистрированных пользователей
    @PutMapping
    @RequestMapping(value = "/update")
    public Set<User> updateStudentEmail(@RequestBody String userName) {
        registrationService.updateStudent(userName);
        return users;
    }

    //Post запрос Удаление пользователя по имени и получение списка всех зарегистрированных пользователей
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Set<User> deleteStudent(@RequestBody String userName) {
        registrationService.deleteStudent(userName);
        return users;
    }

}
