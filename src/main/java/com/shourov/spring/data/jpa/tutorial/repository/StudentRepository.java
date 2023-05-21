package com.shourov.spring.data.jpa.tutorial.repository;

import com.shourov.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String name);

    List<Student> findByFirstNameContaining(String fragment);

    List<Student> findByGuardianName(String guardianName);


    // JPQL Query
    @Query("select s.firstName from Student s where s.emailId=?1")
    String getStudentFirstNameByEmailAddress(String email);

    // SQL Native Query
    @Query(
            value = "select first_name from tbl_student ts where ts.email_address=?1",
            nativeQuery = true
    )
    String getStudentFirstNameByEmailAddressNative(String email);

    // Query with named parameters
    @Query("select s from Student s where s.emailId=:email")
    Student getStudentByEmailNamedParam(String email);

    // Query with named parameters
    @Query(
            value = "select * from tbl_student ts where ts.email_address=:email",
            nativeQuery = true
    )
    Student getStudentByEmailNamedParamNative(String email);

    // Update record
    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student ts set first_name=:firstName where ts.email_address=:email",
            nativeQuery = true
    )
    Integer updateStudentByEmail(String firstName, String email);
}
