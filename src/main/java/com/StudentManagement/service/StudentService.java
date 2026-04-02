package com.StudentManagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.StudentManagement.dto.StudentDTO;
import com.StudentManagement.exception.ResourceNotFoundException;
import com.StudentManagement.model.Student;
import com.StudentManagement.repository.StudentRepo;

@Service
public class StudentService {
	@Autowired
	StudentRepo repo;
	
	//Entity -> DTO
	public StudentDTO toDTO(Student student) {
		StudentDTO dto = new StudentDTO();
		
		dto.setId(student.getId());
		dto.setSt_name(student.getSt_name());
		dto.setSt_email(student.getSt_email());
		dto.setSt_age(student.getSt_age());
		dto.setSt_course(student.getSt_course());
		
		return dto;
		
	}
	//DTO -> Entity
		public Student toEntity(StudentDTO dto) {
			Student st = new Student();
			
			st.setId(dto.getId());
			st.setSt_name(dto.getSt_name());
			st.setSt_email(dto.getSt_email());
			st.setSt_age(dto.getSt_age());
			st.setSt_course(dto.getSt_course());
			
			return st;
			
		}
	
	public StudentDTO addStudent(StudentDTO dto) {
		Student st = repo.save(toEntity(dto));
		return toDTO(st);
	}
	
	public StudentDTO getStudentById(int id) {
		Student st = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found: " + id));
        return toDTO(st);
	}
	
	public List<StudentDTO> getAllStudents(){
		return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}
	
	// Update
	public StudentDTO updateStudent(int id, StudentDTO dto) {
	    Student existing = repo.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Student not found, ID: " + id));

	    existing.setSt_name(dto.getSt_name());
	    existing.setSt_email(dto.getSt_email());
	    existing.setSt_age(dto.getSt_age());
	    existing.setSt_course(dto.getSt_course());

	    Student updated = repo.save(existing);
	    return toDTO(updated);
	}

	// Delete
	public void delete(int id) {
	    Student existing = repo.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Student not found, ID: " + id));
	    repo.delete(existing);
	}
}
