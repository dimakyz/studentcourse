package dima.dao;

import dima.model.Course;
import dima.model.User;

public interface CourseDao extends GenericDAO<Course, Long> {

    Course getByName(String courseName);

    Course getByUser(User user);

}
