package com.example.university.entity;
import javax.persistence.*;

@Entity
public class StudentCourse {
    @EmbeddedId
    private StudentCourseKey id;

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    private Course course;

    private Double score;

    // Getters and Setters
}
