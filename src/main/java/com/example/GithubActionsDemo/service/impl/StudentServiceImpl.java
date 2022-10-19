package com.example.GithubActionsDemo.service.impl;

import com.example.GithubActionsDemo.dao.StudentRepository;
import com.example.GithubActionsDemo.entity.Student;
import com.example.GithubActionsDemo.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student save(Student entity) {
        return repository.save(entity);
    }

    @Override
    public List<Student> save(List<Student> entities) {
        return (List<Student>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return (List<Student>) repository.findAll();
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        Page<Student> entityPage = repository.findAll(pageable);
        List<Student> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Student update(Student entity, Integer id) {
        Optional<Student> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }

}