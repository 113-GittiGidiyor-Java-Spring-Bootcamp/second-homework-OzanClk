package dev.patika.homework02.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.Set;

@Entity
public class PermanentInstructor extends Instructor {

    private double monthlySalary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_id", referencedColumnName = "id")
    private Instructor instructor;

    public PermanentInstructor(String instructorName, String address, String phoneNumber, Set<Course> courseList, double monthlySalary) {
        super(instructorName, address, phoneNumber, courseList);
        this.monthlySalary = monthlySalary;
    }

    public PermanentInstructor(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public PermanentInstructor() {

    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}

