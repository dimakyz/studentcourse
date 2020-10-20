package dao.map;

import dao.CourseDao;
import dao.UserDao;
import org.springframework.context.annotation.Bean;

public class RepositoryConfig {
    @Bean
    public UserDao getMapUserDAO() {
        return new UserDAOImpl();
    }

    @Bean
    public CourseDao getMapCourseDAO() {
        return new CourseDAOImpl();
    }

}
