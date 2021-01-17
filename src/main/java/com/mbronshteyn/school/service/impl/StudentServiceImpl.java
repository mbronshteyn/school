package com.mbronshteyn.school.service.impl;

import com.mbronshteyn.school.entity.StudentEntity;
import com.mbronshteyn.school.model.dto.StudentDto;
import com.mbronshteyn.school.repository.StudentRepository;
import com.mbronshteyn.school.service.StudentService;
import com.mbronshteyn.school.util.EncryptUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  EncryptUtil encryptUtil;

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public StudentDto createStudent(StudentDto studentDto) {

    StudentEntity studentEntity = new StudentEntity();

    BeanUtils.copyProperties(studentDto, studentEntity);
    studentEntity.setEncryptedPassword(encryptUtil.caesarCipherEncrypt(studentDto.getPassword()));

    StudentEntity responseEntity = studentRepository.save(studentEntity);

    StudentDto result = new StudentDto();
    BeanUtils.copyProperties(responseEntity, result);

    return result;
  }
}
