package dima.service;

import dima.dao.CourseDao;
import dima.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ServiceConfig {

    @Bean
    public UserService userServiceImpl(UserDao userDAO) {
        return new UserServiceImpl(userDAO);
    }

    @Bean
    public CourseServiceImpl courseServiceImpl(CourseDao courseDAO) {
        return new CourseServiceImpl();
    }
}

