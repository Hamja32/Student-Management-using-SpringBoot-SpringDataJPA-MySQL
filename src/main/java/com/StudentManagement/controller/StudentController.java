package com.StudentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.StudentManagement.dto.StudentDTO;
import com.StudentManagement.model.Student;
import com.StudentManagement.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {
	@Autowired
	StudentService service;
	
	@GetMapping("/students")
	public ResponseEntity<List<StudentDTO>> getAllStudentC(){
		List<StudentDTO> studentList = service.getAllStudents();
		if(studentList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(studentList,HttpStatus.OK);
	}
	
	   // GET by ID
    @GetMapping("students/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable int id) {
        StudentDTO dto = service.getStudentById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    // POST - create
    @PostMapping("/students")
    public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO dto) {
        StudentDTO saved = service.addStudent(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // PUT - update
    @PutMapping("students/{id}")
    	public ResponseEntity<StudentDTO> updateStudent(
          @PathVariable int id,
         @Valid @RequestBody StudentDTO dto) {
      StudentDTO updated = service.updateStudent(id, dto);
     return new ResponseEntity<>(updated, HttpStatus.OK);
 }

//    // DELETE
   @DeleteMapping("students/{id}")
   public ResponseEntity<String> deleteStudent(@PathVariable int id) {
     service.delete(id);
       return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
   }
	
}
