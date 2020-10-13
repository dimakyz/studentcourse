package service;

import dao.UserDao;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

public class UserServiceImpl implements UserService {
    private static final Logger log = LogManager.getLogger(UserServiceImpl.class.getName());

    private UserDao userDAO;
    private LocalDateTime currentTime;


    public UserServiceImpl(UserDao userDAO) {
        log.info("createService");
        this.userDAO = userDAO;
    }

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct");
    }

    @Override
    public void setTime(LocalDateTime now) {
        currentTime = now;
    }

    @Override
    public void addStudent(User user) {
        log.info("now: " + LocalDateTime.now() + " currentTime: " + currentTime + " UserService: " + this.toString());
        userDAO.save(user);
    }
}
