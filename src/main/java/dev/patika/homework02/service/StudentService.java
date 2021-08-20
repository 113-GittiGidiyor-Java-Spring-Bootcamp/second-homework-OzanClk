package dev.patika.homework02.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.patika.homework02.controller.StudentController;
import dev.patika.homework02.dao.StudentDAO;
import dev.patika.homework02.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StudentService implements BaseService<Student> {

    private StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO) { //Qualifier Eklenmemiş hali
        this.studentDAO = studentDAO;
    }


    @Override
    public Student save(Student student) {

        return studentDAO.save(student);

    }

    @Override
    public Student findById(int id) {

        return studentDAO.findById(id);

    }

    @Override
    public Student update(Student student) {

        return studentDAO.update(student);
    }

    @Override
    public List<Student> findByAll() {

        return studentDAO.findByAll();

    }

    @Override
    public void deleteById(int id) {

        studentDAO.deleteById(id);

    }
}
