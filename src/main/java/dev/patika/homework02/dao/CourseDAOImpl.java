package dev.patika.homework02.dao;

import dev.patika.homework02.model.Course;
import dev.patika.homework02.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository

public class CourseDAOImpl implements CourseDAO {

    private EntityManager em;

    @Autowired
    public CourseDAOImpl(EntityManager em) {

        this.em = em;

    }


    @Override
    @Transactional
    public Course save(Course course) {

        return em.merge(course);

    }

    @Override
    public Course findById(int id) {

        return em.find(Course.class, id);

    }

    @Override
    @Transactional
    public Course update(Course course) {

        return em.merge(course);

    }

    @Override
    public List<Course> findByAll() {

        return em.createQuery("FROM Course c", Course.class).getResultList();

    }

    @Override
    @Transactional
    public void deleteById(int id) {

        Course findCourse = em.find(Course.class, id);

        em.remove(findCourse);
    }
}
