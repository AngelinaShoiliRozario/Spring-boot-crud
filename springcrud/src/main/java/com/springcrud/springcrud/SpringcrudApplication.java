package com.springcrud.springcrud;

import com.springcrud.springcrud.dao.CourseDAO;
import com.springcrud.springcrud.dao.StudentDAO;
import com.springcrud.springcrud.dao.StudentDAOImplementation;
import com.springcrud.springcrud.entity.Course;
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
	public CommandLineRunner commandLineRunner(CourseDAO courseDAO){
		return runner->{
			System.out.println("the code started");

		};
	}

	// course functions
	public void createCourse(CourseDAO courseDAO){
		Course course1 = new Course("Advance Data Structure and Algorithm",500);
		Course course2 = new Course("System Design",2000);
		Course course3 = new Course("Data Intensive Application",500);
		// save the course
		courseDAO.create(course1);
		courseDAO.create(course2);
		courseDAO.create(course3);
		System.out.println("Course created successfully! ");
	}
	public void showAllCourse(CourseDAO courseDAO){
		courseDAO.showAll();
	}


//	student functions
	public void createStudent(StudentDAO studentDAO){
		Student student = new Student("Angelina","Rozario","shoili.rozario@gmail.com");
		System.out.println("Saving the Student...............");
		studentDAO.save(student);
		System.out.println("Saved the student, id = " + student.toString());
	}
	public void createManyStudent(StudentDAO studentDAO){
		Student student1 = new Student("Paul","Cruze","s@gmail.com");
		Student student2 = new Student("Shaun","Rozario","s@gmail.com");
		Student student3 = new Student("Rickson","Akter","shoili@gmail.com");
		Student student4 = new Student("Sammy","Shamual","s@gmail.com");
		Student student5 = new Student("Daniel","Prek","so@gmail.com");
		System.out.println("Saving the Student...............");
		studentDAO.save(student1);
		System.out.println("Saved the student, id = " + student1.toString());
		studentDAO.save(student2);
		System.out.println("Saved the student, id = " + student2.toString());
		studentDAO.save(student3);
		System.out.println("Saved the student, id = " + student3.toString());
		studentDAO.save(student4);
		System.out.println("Saved the student, id = " + student4.toString());
		studentDAO.save(student5);
		System.out.println("Saved the student, id = " + student5.toString());
		System.out.println("Saved Five Students.................");
	}
	public void findStudent(StudentDAO studentDAO){
		Student student = studentDAO.findById(1);
		System.out.println("student found "+ student.toString());
	}
	public void getAllStudent(StudentDAO studentDAO){
		List<Student> students = studentDAO.findAll();
		for(Student tempStudent : students){
			System.out.println("Student "+tempStudent.toString());
		}
	}
	public void getStudentByName(StudentDAO studentDAO){
		List<Student> students = studentDAO.findByLastName("Smini");
		for(Student tempStudent : students){
			System.out.println(tempStudent.toString());
		}
	}
	public void updateStudent(StudentDAO studentDAO){
		Student student = studentDAO.findById(1);
		student.setFirstName("Shoili");
		studentDAO.update(student);
	}
	public void deleteStudentById(StudentDAO studentDAO){
		System.out.println("Deleting the Student ................");
		studentDAO.delete(3);
	}
	public void deleteManyStudent(StudentDAO studentDAO){
		studentDAO.deleteManyByEmail("s@gmail.com");
	}
	public void deleteAllStudent(StudentDAO studentDAO){
		studentDAO.deleteAll();
	}
}
