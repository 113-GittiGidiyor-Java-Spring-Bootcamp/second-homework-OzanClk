package dev.patika.homework02.controller;


import dev.patika.homework02.model.Course;
import dev.patika.homework02.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {

    private CourseService courseService;

    //Course Service CRUD Operations


    @Autowired
    public CourseController(CourseService courseService) {

        this.courseService = courseService;

    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> findAll() {

        return new ResponseEntity<>(courseService.findByAll(), HttpStatus.OK);

    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Course> findByIdCourse(@PathVariable int id) {

        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);

    }


    @PostMapping("/course")
    public ResponseEntity saveCourse(@RequestBody Course course) {

        try {

            courseService.save(course);

            return ResponseEntity.ok(course);

        } catch (HttpClientErrorException e) {

            return ResponseEntity.status(e.getStatusCode()).body("Save Operation Failed");

        }

    }

    @PutMapping("/course")
    public ResponseEntity updateCourse(@RequestBody Course course) {

        Optional<Course> tempStudent = Optional.ofNullable(courseService.findById(course.getId()));

        if (tempStudent.isPresent()) {

            return new ResponseEntity<>(courseService.update(course), HttpStatus.OK);

        } else {

            return new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);

        }
    }


    @DeleteMapping("/course/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {

        courseService.deleteById(id);

        return new ResponseEntity<>("Course with id number  " + id + " has been deleted", HttpStatus.OK);

    }




}
