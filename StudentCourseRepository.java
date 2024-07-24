package com.example.university.repositery;

import com.example.university.entity.StudentCourse;
import com.example.university.entity.StudentCourseKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, StudentCourseKey> {
    List<StudentCourse> findByCourseName(String courseName);
    List<StudentCourse> findByCourseNameAndStudentIsNull(String courseName);
}
