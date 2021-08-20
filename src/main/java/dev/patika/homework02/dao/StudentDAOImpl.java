package dev.patika.homework02.dao;

import dev.patika.homework02.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager em;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {

        this.em = entityManager;

    }


    @Override
    @Transactional
    public Student save(Student student) {

        return em.merge(student);

    }

    @Override
    public Student findById(int id) {

        return em.find(Student.class, id);

    }

    @Override
    @Transactional
    public Student update(Student student) {

        return em.merge(student);

    }

    @Override
    public List<Student> findByAll() {

        return em.createQuery("FROM Student s", Student.class).getResultList();

    }

    @Override
    @Transactional
    public void deleteById(int id) {

        Student findStudent = em.find(Student.class, id);

        em.remove(findStudent);
    }
}
