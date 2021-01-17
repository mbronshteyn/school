package com.mbronshteyn.school.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentDto implements Serializable {
  private static final long serialVersionUID = 1L;
  Long id;
  String userId;
  String firstName;
  String lastName;
  String grade;
  String email;
  String password;
  String encryptedPassword;
  String emailVerificationToken;
  String emailVerificationStatus;
}
