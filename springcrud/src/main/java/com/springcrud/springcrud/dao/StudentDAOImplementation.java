package com.springcrud.springcrud.dao;

import com.springcrud.springcrud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //Student tempStudent = entityManager.find(Student.class,id);
        //entityManager.remove(tempStudent);

        //OR

        Query theQuery = entityManager.createQuery("DELETE FROM Student WHERE id = :theid");
        theQuery.setParameter("theid",id);
        theQuery.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteManyByEmail(String email) {
        Query theQuery = entityManager.createQuery("DELETE FROM Student WHERE email = :email");
        theQuery.setParameter("email",email);
        theQuery.executeUpdate();
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
