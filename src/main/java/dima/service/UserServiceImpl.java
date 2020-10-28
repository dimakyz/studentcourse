package dima.service;

import dima.dao.UserDao;
import dima.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@PropertySource(value = {"classpath:application.properties"})
public class UserServiceImpl implements UserService {
    private static final Logger log = LogManager.getLogger(UserServiceImpl.class.getName());

    @Value("${user.minAge}")
    private int minAge;

    private UserDao userDAO;
    private LocalDateTime currentTime;


    public UserServiceImpl(UserDao userDAO) {
        log.info("createService");
        this.userDAO = userDAO;
    }

    @Override
    public void setTime(LocalDateTime now) {
        currentTime = now;
    }

    //Добавление студента
    @Override
    public void addStudent(User user) {
        if (user.getAge() < minAge) {
            throw new RuntimeException("Age must be more than " + minAge);
        }
        else {
            userDAO.save(user);
            log.info("Added student: " + user.getUsername() + " currentTime: " + LocalDateTime.now() + " UserService: " + this.toString());
        }
    }
}