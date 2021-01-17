package com.mbronshteyn.school.controllers;

import com.mbronshteyn.school.model.dto.StudentDto;
import com.mbronshteyn.school.model.request.StudentRest;
import com.mbronshteyn.school.service.StudentService;
import io.beanmapper.config.BeanMapperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

  @Autowired private StudentService studentService;

  @GetMapping
  public ResponseEntity<List<StudentRest>> getAllStudents() {
    return ResponseEntity.ok().body(studentService.getStudents().stream()
        .map(s -> new BeanMapperBuilder().build().map(s, StudentRest.class))
        .collect(Collectors.toList()));
  }

  @PostMapping
  public ResponseEntity<StudentRest> createStudent(@RequestBody StudentRest studentRest) {

    StudentDto studentDto = new BeanMapperBuilder().build().map(studentRest, StudentDto.class);

    StudentDto response = studentService.createStudent(studentDto);

    return ResponseEntity.ok()
        .body(new BeanMapperBuilder().build().map(response, StudentRest.class));
  }

  @DeleteMapping
  public String deleteStudent() {
    return "delete student was called";
  }

  @PutMapping
  public String updateStudent() {
    return "update student was called";
  }
}
