package dev.patika.homework02.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class VisitingInstructor extends Instructor {

    private double hourlySalary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_id", referencedColumnName = "id")
    private Instructor instructor;

    public VisitingInstructor(String instructorName, String address, String phoneNumber, Set<Course> courseList, double hourlySalary) {

        super(instructorName, address, phoneNumber, courseList);
        this.hourlySalary = hourlySalary;

    }

    public VisitingInstructor(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public VisitingInstructor() {
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
