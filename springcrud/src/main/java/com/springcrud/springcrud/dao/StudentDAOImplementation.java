package com.springcrud.springcrud.dao;

import com.springcrud.springcrud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImplementation implements StudentDAO{
    private EntityManager entityManager;
    @Autowired
    public StudentDAOImplementation(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName = :thedata", Student.class);
        theQuery.setParameter("thedata",lastName);
        return theQuery.getResultList();
    }

}
