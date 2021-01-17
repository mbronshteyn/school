package com.mbronshteyn.school.controllers;

import com.mbronshteyn.school.model.dto.StudentDto;
import com.mbronshteyn.school.model.request.StudentRest;
import com.mbronshteyn.school.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @GetMapping
  public String getStudent() {
    return "get student was called";
  }

  @PostMapping
  public StudentRest createStudent(@RequestBody StudentRest studentRest) {

    StudentRest returnValue = new StudentRest();

    StudentDto studentDto = new StudentDto();
    BeanUtils.copyProperties(studentRest, studentDto);

    StudentDto response = studentService.createStudent(studentDto);

    BeanUtils.copyProperties(response, returnValue);

    return returnValue;
  }


  @DeleteMapping
  public String deleteStudent(){
    return "delete student was called";
  }

  @PutMapping
  public String updateStudent(){
    return "update student was called";
  }
}
