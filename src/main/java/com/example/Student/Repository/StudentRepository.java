package com.example.Student.Repository;

import com.example.Student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Custom query to find students registered in a specific year

    List<Student> findByYearOfEnrollment(int yearOfEnrollment);

    // Custom query to retrieve only the department by student ID

    @Query("SELECT s.department FROM Student s WHERE s.id = :id")
    String findDepartmentById(@Param("id") long id);

    // Custom query to delete all students by year of enrollment
    void deleteByYearOfEnrollment(Integer yearOfEnrollment);

}
