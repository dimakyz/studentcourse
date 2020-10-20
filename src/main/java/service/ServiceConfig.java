package service;

import dao.CourseDao;
import dao.UserDao;
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

