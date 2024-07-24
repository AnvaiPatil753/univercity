package com.example.university.controller;
import com.example.university.entity.Student;
import com.example.university.entity.StudentCourse;
import com.example.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public void addStudent(@RequestBody Student student, @RequestBody List<StudentCourse> studentCourses) {
        studentService.addStudent(student, studentCourses);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @GetMapping("/course/{courseName}")
    public List<Student> getStudentsByCourseName(@PathVariable String courseName) {
        return studentService.getStudentsByCourseName(courseName);
    }

    @GetMapping("/not-in-course/{courseName}")
    public List<Student> getStudentsNotInCourse(@PathVariable String courseName) {
        return studentService.getStudentsNotInCourse(courseName);
    }
}
