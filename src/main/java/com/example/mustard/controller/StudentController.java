package com.example.mustard.controller;

import com.example.mustard.entity.Student;
import com.example.mustard.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/students/")
public class StudentController {
    StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Student> getStuds(){
        return service.getStudents();
    }

    @PostMapping()
    public void registerStudent(@RequestBody Student student){
        service.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        service.deleteStudent(id);
    }
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long id,
            @RequestParam(required = false) String name
            ){
        service.updateStudent(id,name);
    }
}
