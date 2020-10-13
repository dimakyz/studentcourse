package service;

import dao.CourseDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Course;

public class CourseServiceImpl implements CourseService {

    private static final Logger log = LogManager.getLogger(CourseServiceImpl.class.getName());

    private CourseDao courseDAO;

    @Override
    public void addCourse(Course course) {
        courseDAO.save(course);
    }

    public void setCourseDAO(CourseDao courseDAO) {
        this.courseDAO = courseDAO;
    }
}
