package com.example.university.entity;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class StudentCourseKey {
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "course_id")
    private Long courseId;

    // Getters, Setters, hashCode, and equals
}
