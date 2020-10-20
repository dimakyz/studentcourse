package service;

import dao.UserDao;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Service
@Scope("prototype")
@PropertySource(value = {"classpath:application.properties"})
public class UserServiceImpl implements UserService {
    private static final Logger log = LogManager.getLogger(UserServiceImpl.class.getName());

    @Value("${user.minAge}")
    private int minAge;

    private UserDao userDAO;
    private LocalDateTime currentTime;
    private UserService self;

    public UserServiceImpl(@Qualifier("userDAOImpl") UserDao userDAO) {
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
        if (user.getAge() < minAge) {
            throw new RuntimeException("Age must be more than " + minAge);
        }
        else {
            userDAO.save(user);
            log.info("Added student: " + user.getUsername() + " currentTime: " + LocalDateTime.now() + " UserService: " + this.toString());
        }
    }

//    @Autowired
//    @Lazy
//    public void setSelf(UserService self) {
//        this.self = self;
//    }
}
