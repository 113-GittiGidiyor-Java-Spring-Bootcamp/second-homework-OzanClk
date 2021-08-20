package dev.patika.homework02.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String instructorName;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "instructor")
    @JsonIgnore
    private Set<Course> instructorCourses;

    public Instructor(String instructorName, String address, String phoneNumber, Set<Course> instructorCourses) {
        this.instructorName = instructorName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.instructorCourses = instructorCourses;
    }


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "instructor")
    private PermanentInstructor permanentInstructor;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "instructor")
    private VisitingInstructor visitingInstructor;

    public Instructor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Course> getInstructorCourses() {
        return instructorCourses;
    }

    public void setInstructorCourses(Set<Course> instructorCourses) {
        this.instructorCourses = instructorCourses;
    }
}

