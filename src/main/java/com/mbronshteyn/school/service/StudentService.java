package com.mbronshteyn.school.service;

import com.mbronshteyn.school.model.dto.StudentDto;
import com.mbronshteyn.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface StudentService {

  StudentDto createStudent(StudentDto studentDto);
}
