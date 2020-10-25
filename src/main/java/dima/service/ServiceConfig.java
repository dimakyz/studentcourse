package dima.service;

import dima.dao.CourseDao;
import dima.dao.UserDao;
import org.springframework.context.annotation.Bean;

public class ServiceConfig {

    @Bean
    public UserService userServiceImpl(UserDao userDAO) {
        return new UserServiceImpl(userDAO);
    }

    @Bean
    public CourseService courseServiceImpl(CourseDao courseDAO) {
        return new CourseServiceImpl();
    }
}

