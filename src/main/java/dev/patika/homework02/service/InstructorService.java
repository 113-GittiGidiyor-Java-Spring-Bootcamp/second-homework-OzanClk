package dev.patika.homework02.service;


import dev.patika.homework02.dao.InstructorDAO;
import dev.patika.homework02.model.Instructor;
import dev.patika.homework02.model.PermanentInstructor;
import dev.patika.homework02.model.VisitingInstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService implements BaseService<Instructor> {

    private InstructorDAO instructorDAO;

    @Autowired
    public InstructorService(@Qualifier("InstructorDAOImpl") InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }


    @Override
    public Instructor save(Instructor instructor) {

        if (instructor instanceof PermanentInstructor) {
            return instructorDAO.save((PermanentInstructor) instructor);
        } else if (instructor instanceof VisitingInstructor) {
            return instructorDAO.save((VisitingInstructor) instructor);
        }

        return null;

    }

    @Override
    public Instructor findById(int id) {
        return instructorDAO.findById(id);
    }

    @Override
    public Instructor update(Instructor instructor) {

        return instructorDAO.update(instructor);

    }

    @Override
    public List<Instructor> findByAll() {

        return instructorDAO.findByAll();

    }

    @Override
    public void deleteById(int id) {

        instructorDAO.deleteById(id);

    }
}
