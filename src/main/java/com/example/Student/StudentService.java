package com.example.Student;

import com.example.Student.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student createStudent(Student student);

    Optional<Student> getStudentById(Long id);

    List<Student> getAllStudents();

    Student updateStudent(Long id, Student student);

    Boolean deleteStudent(Long id);

    // custom methods
    List<Student> getStudentsByYearOfEnrollment(Integer yearOfEnrollment);

    String getDepartmentById(Long id);

    void removeByYearOfEnrollment(Integer yearOfEnrollment);

}
