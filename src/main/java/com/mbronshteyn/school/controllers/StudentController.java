package com.mbronshteyn.school.controllers;

import com.mbronshteyn.school.model.request.StudentRest;
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
  @GetMapping
  public String getStudent(){
    return "get student was called";
  }

  @PostMapping
  public StudentRest postStudent(@RequestBody StudentRest studentRest){
    return studentRest;
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
