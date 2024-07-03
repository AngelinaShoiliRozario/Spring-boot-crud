package com.springcrud.springcrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="course_name")
    private String courseName;

    @Column(name="price")
    private Integer price;

    public Course() {
    }

    public Course(String courseName, Integer price) {
        this.courseName = courseName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
