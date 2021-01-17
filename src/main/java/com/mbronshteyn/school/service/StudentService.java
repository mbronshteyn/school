package com.mbronshteyn.school.service;

import com.mbronshteyn.school.model.dto.StudentDto;
import com.mbronshteyn.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface StudentService {

  StudentDto createStudent(StudentDto studentDto);

  List<StudentDto> getStudents();
}
