package com.springcrud.springcrud.dao;

import com.springcrud.springcrud.entity.Course;

import java.util.List;


public interface CourseDAO {
    void create(Course course);
    Course findById(Integer id);
    List<Course> findAll();
    void showAll();
    Course findByName(String Name);
    void Update(Course course);
    void Delete(String name);
    void DeleteAll();

}
