package service;

import config.SpringConfig;
import model.Course;
import model.CourseStatus;
import model.User;
import model.UserStatus;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
public class MainService {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserService userService = (UserService) context.getBean("userServiceImpl");
        CourseService courseService = (CourseService) context.getBean("courseServiceImpl");

        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername("Student1");
        user.setEmail("test@test.ru");
        user.setPassword("password");
        user.setAge(25);
        user.setUserStatus(UserStatus.STATUS_ACTIVED);

        userService.addStudent(user);

        User user2 = new User();
        user2.setId(UUID.randomUUID());
        user2.setUsername("Student2");
        user2.setEmail("test@test2.ru");
        user2.setPassword("password");
        user2.setAge(18);
        user2.setUserStatus(UserStatus.STATUS_ACTIVED);
        userService.addStudent(user2);

        Set<User> users = new HashSet<>();
        users.add(user);
        users.add(user2);

        Course course = new Course();
        course.setId(1L);
        course.setCourseName("Курс 1");
        course.setCourseStatus(CourseStatus.STATUS_CREATED);
        course.setEndTime(LocalDateTime.now().plusMonths(1));
        course.setUsers(users);
        courseService.addCourse(course);

    }
}
