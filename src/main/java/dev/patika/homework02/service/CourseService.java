package dev.patika.homework02.service;

import dev.patika.homework02.controller.StudentController;
import dev.patika.homework02.dao.CourseDAO;
import dev.patika.homework02.model.Course;
import dev.patika.homework02.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements BaseService<Course> {

    private CourseDAO courseDAO;

    @Autowired
    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }


    @Override
    public Course save(Course course) {

        return courseDAO.save(course);

    }

    @Override
    public Course findById(int id) {

        return courseDAO.findById(id);

    }

    @Override
    public Course update(Course course) {

        return courseDAO.update(course);

    }

    @Override
    public List<Course> findByAll() {

        return courseDAO.findByAll();

    }

    @Override
    public void deleteById(int id) {

        courseDAO.deleteById(id);

    }
}
