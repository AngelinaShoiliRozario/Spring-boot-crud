package com.springcrud.springcrud.dao;

import com.springcrud.springcrud.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
}
