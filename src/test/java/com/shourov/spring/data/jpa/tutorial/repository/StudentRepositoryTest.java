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

        Student student2 = Student
                .builder()
                .firstName("Henrick")
                .lastName("Rogers")
                .emailId("henrickrogers@hotmail.com")
                .guardian(
                        Guardian
                                .builder()
                                .name("John")
                                .email("john@gmail.com")
                                .mobile("95877556621")
                                .build()
                )
                .build();

        repository.save(student);
        repository.save(student2);
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
    public void printStudentFirstNameByEmail() {
        System.out.println(repository.getStudentFirstNameByEmailAddress("shourovcseruet@gmail.com"));
    }

    @Test
    public void printStudentFirstNameByEmailNative() {
        System.out.println(repository.getStudentFirstNameByEmailAddressNative("shourovcseruet@gmail.com"));
    }

    @Test
    public void printStudentByEmailNamedParam() {
        System.out.println(repository.getStudentByEmailNamedParam("shourovcseruet@gmail.com"));
    }

    @Test
    public void printStudentByEmailNamedParamNative() {
        System.out.println(repository.getStudentByEmailNamedParamNative("henrickrogers@hotmail.com"));
    }

    @Test
    public void updateStudentByEmail() {
        System.out.println(repository.updateStudentByEmail("Henry", "henrickrogers@hotmail.com"));
    }

}