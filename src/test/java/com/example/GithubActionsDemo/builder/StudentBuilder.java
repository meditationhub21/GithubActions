package com.example.GithubActionsDemo.builder;

import com.example.GithubActionsDemo.dto.StudentDTO;
import com.example.GithubActionsDemo.entity.Student;

import java.util.Arrays;
import java.util.List;

public class StudentBuilder {
    public static List<StudentDTO> getListDTO() {
        return Arrays.asList(new StudentDTO(101, "Student01", "123456789", "s01@gmail.com"),
                new StudentDTO(102, "Student02", "987654321", "s02@gmail.com"),
                new StudentDTO(103, "Student03", "5432167890", "s03@gmail.com"));
    }

    public static List<Student> getListEntities() {
        return Arrays.asList(new Student(101, "Student01", "123456789", "s01@gmail.com"),
                new Student(102, "Student02", "987654321", "s02@gmail.com"),
                new Student(103, "Student03", "5432167890", "s03@gmail.com"));
    }

    public static StudentDTO getDTO() {
        return new StudentDTO(101, "Student01", "123456789", "s01@gmail.com");
    }

    public static Student getEntity() {
        return new Student(101, "Student01", "123456789", "s01@gmail.com");
    }
}
