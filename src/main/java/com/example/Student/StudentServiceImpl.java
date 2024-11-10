package com.example.Student;

import com.example.Student.Student;
import com.example.Student.Repository.StudentRepository;
import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student studentDetails) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        existingStudent.setFirstName(studentDetails.getFirstName()); // Use the generated setter
        existingStudent.setLastName(studentDetails.getLastName()); // Use the generated setter
        existingStudent.setEmail(studentDetails.getEmail()); // Use the generated setter
        return studentRepository.save(existingStudent); // Save the updated student
    }

    @Override
    public Boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true; // Return true if deletion was successful
        }
        return false; // Return false if the student was not found
    }
}
