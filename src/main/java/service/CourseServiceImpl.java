package service;

import dao.CourseDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private static final Logger log = LogManager.getLogger(CourseServiceImpl.class.getName());

    private CourseDao courseDAO;

    @Override
    public void addCourse(Course course) {
        courseDAO.save(course);
    }

    @Autowired
    @Qualifier("courseDAOImpl")
    @Lazy
    public void setCourseDAO(CourseDao courseDAO) {
        this.courseDAO = courseDAO;
    }
}
