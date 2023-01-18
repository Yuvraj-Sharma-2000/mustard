package com.example.mustard.service;

import com.example.mustard.entity.Student;
import com.example.mustard.repo.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo repo;

    @Autowired
    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }

    public List<Student> getStudents(){
        return repo.findAll();
    }

    public void addNewStudent(Student student) {
//        System.out.println(student);
        if (repo.findStudentByName(student.getName()).isPresent()){
            throw new IllegalStateException("name already exist");
        }
        repo.save(student);
    }

    public void deleteStudent(Long id) {
        if(!repo.existsById(id)){
            throw new IllegalStateException("No such student");
        }
        repo.deleteById(id);

    }

    @Transactional
    public void updateStudent(Long id, String name) {
        Optional<Student> student = repo.findById(id);
        student.get().setName(name);
    }
}
