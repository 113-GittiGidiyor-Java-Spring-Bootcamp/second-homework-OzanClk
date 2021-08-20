package dev.patika.homework02.controller;


import dev.patika.homework02.model.Instructor;
import dev.patika.homework02.model.PermanentInstructor;
import dev.patika.homework02.model.VisitingInstructor;
import dev.patika.homework02.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class InstructorController {

    private InstructorService instructorService;

    //Instructor Service CRUD Operations

    @Autowired
    public InstructorController(InstructorService instructorService) {

        this.instructorService = instructorService;

    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> findAll() {

        return new ResponseEntity<>(instructorService.findByAll(), HttpStatus.OK);

    }

    @GetMapping("/instructor/{id}")
    public ResponseEntity<Instructor> findByIdInstructor(@PathVariable int id) {

        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);

    }


    @PostMapping("/instructor/{salarytype}")
    public ResponseEntity saveCourse(@PathVariable String salarytype, @RequestParam double amount, @RequestBody Instructor instructor) {

        //The only service written for hourly and monthly instrucors.For this, salary type and amount values should be taken from the user.

        try {

            if (salarytype.equals("monthly")) {

                PermanentInstructor permanentInstructor = new PermanentInstructor();
                permanentInstructor.setInstructor(instructor);
                permanentInstructor.setMonthlySalary(amount);

                instructorService.save(permanentInstructor);
            } else if (salarytype.equals("hourly")) {

                VisitingInstructor visitingInstructor = new VisitingInstructor();
                visitingInstructor.setInstructor(instructor);
                visitingInstructor.setHourlySalary(amount);

                instructorService.save(visitingInstructor);
            }


            return ResponseEntity.ok(instructor);

        } catch (HttpClientErrorException e) {

            return ResponseEntity.status(e.getStatusCode()).body("Save Operation Failed");

        }

    }

    @PutMapping("/instructor")
    public ResponseEntity updateInstructor(@RequestBody Instructor instructor) {

        Optional<Instructor> tempStudent = Optional.ofNullable(instructorService.findById(instructor.getId()));

        if (tempStudent.isPresent()) {

            return new ResponseEntity<>(instructorService.update(instructor), HttpStatus.OK);

        } else {

            return new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);

        }
    }


    @DeleteMapping("/instructor/{id}")
    public ResponseEntity<String> deleteInstructor(@PathVariable int id) {

        instructorService.deleteById(id);

        return new ResponseEntity<>("Instructor with id number  " + id + " has been deleted", HttpStatus.OK);

    }


}
