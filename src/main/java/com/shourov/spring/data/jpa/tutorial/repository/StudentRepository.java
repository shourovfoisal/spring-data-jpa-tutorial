package com.shourov.spring.data.jpa.tutorial.repository;

import com.shourov.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String name);

    List<Student> findByFirstNameContaining(String fragment);

    List<Student> findByGuardianName(String guardianName);


    @Query("select s.firstName from Student s where s.emailId=?1")
    String getStudentFirstNameByEmailAddress(String email);
}
