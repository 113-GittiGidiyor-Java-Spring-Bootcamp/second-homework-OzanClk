package dev.patika.homework02.dao;

import dev.patika.homework02.model.Course;
import dev.patika.homework02.model.Instructor;
import dev.patika.homework02.model.PermanentInstructor;
import dev.patika.homework02.model.VisitingInstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Qualifier(value = "InstructorDAOImpl")
public class InstructorDAOImpl implements InstructorDAO {

    private EntityManager em;

    @Autowired
    public InstructorDAOImpl(EntityManager em) {

        this.em = em;

    }


    @Override
    @Transactional
    public Instructor save(Instructor instructor) {

        if (instructor instanceof PermanentInstructor) {

            return (PermanentInstructor) em.merge(instructor);

        } else if (instructor instanceof VisitingInstructor) {

            return (VisitingInstructor) em.merge(instructor);

        }

        return null;

    }

    @Override
    public Instructor findById(int id) {

        return em.find(Instructor.class, id);

    }

    @Override
    @Transactional
    public Instructor update(Instructor instructor) {

        return em.merge(instructor);

    }

    @Override
    public List<Instructor> findByAll() {

        return em.createQuery("FROM Instructor i", Instructor.class).getResultList();

    }

    @Override
    @Transactional
    public void deleteById(int id) {

        Instructor findInstructor = em.find(Instructor.class, id);

        em.remove(findInstructor);

    }
}
