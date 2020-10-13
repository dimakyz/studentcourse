package dao;

import model.Course;
import model.User;

public interface CourseDao extends GenericDAO<Course, Long> {

    Course getByName(String courseName);

    Course getByUser(User user);

}
