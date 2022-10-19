package com.example.GithubActionsDemo.mapper;

import com.example.GithubActionsDemo.dto.StudentDTO;
import com.example.GithubActionsDemo.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper extends GenericMapper<Student, StudentDTO> {
    @Override
    @Mapping(target = "id", ignore = true)
    Student asEntity(StudentDTO dto);
}