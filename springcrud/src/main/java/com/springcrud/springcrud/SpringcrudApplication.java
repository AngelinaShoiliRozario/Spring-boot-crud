package com.springcrud.springcrud;

import com.springcrud.springcrud.dao.StudentDAO;
import com.springcrud.springcrud.dao.StudentDAOImplementation;
import com.springcrud.springcrud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcrudApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			System.out.println("The Project beans has been loaded");
			getStudentByName(studentDAO);
		};
	}

	public void createStudent(StudentDAO studentDAO){
		Student student = new Student("Angelina","Rozario","shoili.rozario@gmail.com");
		System.out.println("Saving the Student...............");
		studentDAO.save(student);
		System.out.println("Saved the student, id = " + student.toString());
	}
	public void findStudent(StudentDAO studentDAO){
		Student student = studentDAO.findById(1);
		System.out.println("student found "+ student.toString());
	}
	public void getAllStudent(StudentDAO studentDAO){
		List<Student> students = studentDAO.findAll();
		for(Student tempStudent : students){
			System.out.println("Student "+tempStudent.getFirstName());
		}
	}
	public void getStudentByName(StudentDAO studentDAO){
		List<Student> students = studentDAO.findByLastName("Smini");
		for(Student tempStudent : students){
			System.out.println(tempStudent.toString());
		}
	}
}
