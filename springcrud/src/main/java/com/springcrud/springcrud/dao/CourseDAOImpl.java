package com.springcrud.springcrud.dao;

import com.springcrud.springcrud.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDAOImpl implements  CourseDAO {
    private EntityManager entityManager;

    public CourseDAOImpl(EntityManager theentityManager) {
        this.entityManager = theentityManager;
    }

    @Override
    @Transactional
    public void create(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findById(Integer id) {
        return  entityManager.find(Course.class, id);
    }

    @Override
    public List<Course> findAll() {
        TypedQuery<Course> theQuery = entityManager.createQuery("FROM Course",Course.class);
        return theQuery.getResultList();
    }

    @Override
    public void showAll() {
        TypedQuery<Course> theQuery = entityManager.createQuery("FROM Course",Course.class);
        List<Course> courses = theQuery.getResultList();
        for(Course course : courses){
            System.out.println(course.toString());
        }
    }

    @Override
    public Course findByName(String name) {
        TypedQuery<Course> theQuery = entityManager.createQuery("FROM Course WHERE Name = :theName", Course.class);
        theQuery.setParameter("theName",name);
        return theQuery.getSingleResult();
    }

    @Override
    @Transactional
    public void Update(Course course) {
        entityManager.persist(course);
    }

    @Override
    @Transactional
    public void Delete(String name) {
        TypedQuery<Course> theQuery = entityManager.createQuery("DELETE FROM Course WHERE name = :name", Course.class);
        theQuery.setParameter("name",name);
        theQuery.executeUpdate();
    }

    @Override
    @Transactional
    public void DeleteAll() {
        TypedQuery<Course> theQuery = entityManager.createQuery("DELETE FROM Course", Course.class);
        theQuery.executeUpdate();
    }
}
