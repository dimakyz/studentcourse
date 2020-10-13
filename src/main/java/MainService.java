import model.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import model.CourseStatus;

import model.User;
import model.UserStatus;
import service.CourseService;
import service.UserService;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class MainService {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        UserService userService = (UserService) context.getBean("userService");
        CourseService courseService = (CourseService) context.getBean("courseService");

        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername("User1");
        user.setEmail("test@test.ru");
        user.setPassword("password");
        user.setUserStatus(UserStatus.STATUS_ACTIVED);

        userService.addStudent(user);
        userService = (UserService) context.getBean("userService");

        userService.addStudent(user);
        userService.addStudent(user);
        User user2 = new User();
        user2.setId(UUID.randomUUID());
        user2.setUsername("User2");
        user2.setEmail("test@test2.ru");
        user2.setPassword("password");
        user2.setUserStatus(UserStatus.STATUS_ACTIVED);

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
