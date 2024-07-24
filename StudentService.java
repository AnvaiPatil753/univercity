package com.example.university.service;
import com.example.university.entity.Student;
import com.example.university.entity.StudentCourse;
import com.example.university.repository.StudentRepository;
import com.example.university.repository.StudentCourseRepository;
import com.example.university.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public void addStudent(Student student, List<StudentCourse> studentCourses) {
        studentRepository.save(student);
        studentCourseRepository.saveAll(studentCourses);
    }

    @Transactional
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public List<Student> getStudentsByCourseName(String courseName) {
        return studentCourseRepository.findByCourseName(courseName)
                .stream()
                .map(StudentCourse::getStudent)
                .distinct()
                .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                .toList();
    }

    public List<Student> getStudentsNotInCourse(String courseName) {
        return studentCourseRepository.findByCourseNameAndStudentIsNull(courseName)
                .stream()
                .map(StudentCourse::getStudent)
                .distinct()
                .toList();
    }
}
