package dima.service;

import dima.dao.CourseDao;
import dima.model.Course;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Сервис по добавлению курса
@Service
public class CourseServiceImpl implements CourseService {

    private static final Logger log = LogManager.getLogger(CourseServiceImpl.class.getName());

    private CourseDao courseDAO;

    public CourseServiceImpl() {
        this.courseDAO = courseDAO;
    }

    @Override
    public void addCourse(Course course) {
        courseDAO.save(course);
    }

    @Autowired
    public void setCourseDAO(CourseDao courseDAO) {
        this.courseDAO = courseDAO;
    }
}
