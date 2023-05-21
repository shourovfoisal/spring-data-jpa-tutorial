package com.shourov.spring.data.jpa.tutorial.repository;

import com.shourov.spring.data.jpa.tutorial.entity.Guardian;
import com.shourov.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository repository;

    @Test
    public void saveStudent() {
        Student student = Student
                .builder()
                .firstName("Shourov")
                .lastName("Foisal")
                .emailId("shourovcseruet@gmail.com")
                .guardian(
                        Guardian
                                .builder()
                                .name("Yeakub")
                                .email("yeakub@yahoo.com")
                                .mobile("01712552244")
                                .build()
                )
                .build();

        repository.save(student);
    }

    @Test
    public void printAllStudent() {
        System.out.println(repository.findAll());
    }

    @Test
    public void printStudentByFirstName() {
        System.out.println(repository.findByFirstName("Shourov"));
    }

    @Test
    public void printStudentByFirstNameContaining() {
        System.out.println(repository.findByFirstNameContaining("gh"));
    }

    @Test
    public void printStudentByGuardianName() {
        System.out.println(repository.findByGuardianName("Yeakub"));

    }

    @Test
    public void printStudentByEmail() {
        System.out.println(repository.getStudentFirstNameByEmailAddress("shourovcseruet@gmail.com"));
    }

}