package dima.service;

import dima.controller.dto.UserDto;
import dima.dao.UserDao;
import dima.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.locks.LockSupport;

//Сервис для регистрации студента
@Service
public class RegServiceImpl implements RegistrationService {
    private static final Logger logger = LogManager.getLogger(RegServiceImpl.class.getName());
    private UserDao userDao;
    private RegistrationService registrationService;

    public RegServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public static Set<User> users = new HashSet<>();

    @Override
    public Set<User> regStudent(UserDto userDto) {
        User user = new User(UUID.randomUUID(), userDto.getAge(), userDto.getUsername(), userDto.getPassword(), userDto.getEmail());
        userDao.save(user);
        userDto.setId(user.getId());
        users.add(user);
        registrationService.postOperation(user);
        return users;
    }
    @Override
    public Set<User> updateStudent(String userName) {
        User user = userDao.findStudentByName(userName);
        user.setEmail("new@email.ru");
        return users;
    }
    @Override
    public User getStudent(String userName) {
        User user = userDao.findStudentByName(userName);
        return user;
    }
    @Override
    public Set<User> deleteStudent(String userName) {
        User user = userDao.findStudentByName(userName);
        users.remove(user);
        return users;
    }

    @Override
    @Async
    public void postOperation(User user) {
        LockSupport.parkNanos(5_000_000_000L);
        logger.info("post operation for " + user.getId());
        throw new RuntimeException("passwordException");
    }

}
