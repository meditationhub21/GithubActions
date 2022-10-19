package com.example.GithubActionsDemo.controller;

import com.example.GithubActionsDemo.dto.StudentDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Student API")
public interface StudentController {
    @ApiOperation("Add new data")
    public StudentDTO save(@RequestBody StudentDTO student);

    @ApiOperation("Find by Id")
    public StudentDTO findById(@PathVariable("id") Integer id);

    @ApiOperation("Delete based on primary key")
    public String delete(@PathVariable("id") Integer id);

    @ApiOperation("Find all data")
    public List<StudentDTO> list();

    @ApiOperation("Pagination request")
    public Page<StudentDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public StudentDTO update(@RequestBody StudentDTO dto, @PathVariable("id") Integer id);
}