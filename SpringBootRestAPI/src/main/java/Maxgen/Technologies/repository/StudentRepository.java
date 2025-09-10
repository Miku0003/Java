package Maxgen.Technologies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Maxgen.Technologies.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
