package dev.patika.homework02.controller;


import dev.patika.homework02.model.Student;
import dev.patika.homework02.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentService studentService;

    //Students Service CRUD Operations

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll() {

        return new ResponseEntity<>(studentService.findByAll(), HttpStatus.OK);

    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> findByIdStudent(@PathVariable int id) {

        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);

    }


    @PostMapping("/student")
    public ResponseEntity saveStudent(@RequestBody Student student) {

        try {

            studentService.save(student);

            return ResponseEntity.ok(student);

        } catch (HttpClientErrorException e) {

            return ResponseEntity.status(e.getStatusCode()).body("Save Operation Failed");

        }

    }

    @PutMapping("/student")
    public ResponseEntity updateStudent(@RequestBody Student student) {

        Optional<Student> tempStudent = Optional.ofNullable(studentService.findById(student.getId()));

        if (tempStudent.isPresent()) {

            return new ResponseEntity<>(studentService.update(student), HttpStatus.OK);

        } else {

            return new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);

        }
    }


    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {

        studentService.deleteById(id);

        return new ResponseEntity<>("Student with id number  " + id + "has been deleted", HttpStatus.OK);

    }


}
