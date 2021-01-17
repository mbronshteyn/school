package com.mbronshteyn.school.service.impl;

import com.mbronshteyn.school.entity.StudentEntity;
import com.mbronshteyn.school.model.dto.StudentDto;
import com.mbronshteyn.school.repository.StudentRepository;
import com.mbronshteyn.school.service.StudentService;
import com.mbronshteyn.school.util.EncryptUtil;
import io.beanmapper.config.BeanMapperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired EncryptUtil encryptUtil;

  @Autowired private StudentRepository studentRepository;

  @Override
  public StudentDto createStudent(StudentDto studentDto) {
    StudentEntity studentEntity =
        new BeanMapperBuilder().build().map(studentDto, StudentEntity.class);
    studentEntity.setEncryptedPassword(encryptUtil.caesarCipherEncrypt(studentDto.getPassword()));

    StudentEntity responseEntity = studentRepository.save(studentEntity);

    return new BeanMapperBuilder().build().map(responseEntity, StudentDto.class);
  }

  @Override
  public List<StudentDto> getStudents() {
    return StreamSupport.stream(studentRepository.findAll().spliterator(), false)
        .map(i -> new BeanMapperBuilder().build().map(i, StudentDto.class))
        .collect(Collectors.toList());
  }
}
