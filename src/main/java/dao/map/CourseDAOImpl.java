package dao.map;

import dao.CourseDao;
import model.Course;
import org.springframework.stereotype.Repository;
import model.User;

import java.util.HashMap;

@Repository
public class CourseDAOImpl extends AbstractDao<Course, Long> implements CourseDao {

    public CourseDAOImpl() {
        super(Course.class, new HashMap<>());
    }

    @Override
    public Course getByName(String courseName) {
        for (Course el : elements.values()) {
            if (el.getCourseName().equals(courseName)) {
                return el;
            }
        }
        return null;
    }

    @Override
    public Course getByUser(User user) {
        for (Course course : elements.values()) {
            if (course.getUsers().contains(user)) {
                return course;
            }
        }
        return null;
    }
}