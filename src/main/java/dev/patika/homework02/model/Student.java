package dev.patika.homework02.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate birthDate;
    private String address;
    private String gender;

    @ManyToMany
    private List<Course> studentCourseList;

    public Student(String name, LocalDate birthDate, String address, String gender, List<Course> courseList) {

        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.gender = gender;
        this.studentCourseList = courseList;
    }

    public Student() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Course> getCourseList() {
        return studentCourseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.studentCourseList = courseList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name) && Objects.equals(birthDate, student.birthDate) && Objects.equals(address, student.address) && Objects.equals(gender, student.gender) && Objects.equals(studentCourseList, student.studentCourseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, address, gender, studentCourseList);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", courseList=" + studentCourseList +
                '}';
    }
}
