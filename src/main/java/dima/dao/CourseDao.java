package dima.dao;

import dima.model.Course;
import dima.model.User;

public interface CourseDao extends GenericDAO<Course, Long> {

    // Получение курса по названию
    Course getByName(String courseName);

    // Получение курса по имени
    Course getByUser(User user);

}
