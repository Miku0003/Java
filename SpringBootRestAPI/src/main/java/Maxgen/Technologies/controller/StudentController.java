package Maxgen.Technologies.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Maxgen.Technologies.entity.Student;
import Maxgen.Technologies.repository.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	StudentRepository repo;
	//get all the students
	//localhost:8080/students
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		List<Student> students = repo.findAll();
		return students;
	}//viw all students
	
	//localhost:8080/students/1
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		return student;
	}// view special student
	
	@PostMapping("/student/add")
//	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<String> createStudent(@RequestBody Student student) {
		repo.save(student);
		return ResponseEntity.status(HttpStatus.CREATED).body("Student Inserted Successfully!!!");
	}//add student
	
	@PutMapping("/student/update/{id}")
	public Student updateStudents(@PathVariable int id) {
		Student student = repo.findById(id).get();
		student.setName("Muskan");
		student.setPercentage(98);
		student.setBranch("Mount Abu");
		repo.save(student);
		return student;
	}//for update student
	
	@DeleteMapping("/student/delete/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removeStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		repo.delete(student);
	}//delete student
	
}
