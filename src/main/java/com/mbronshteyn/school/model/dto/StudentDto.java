package com.mbronshteyn.school.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentDto implements Serializable {
  private static final long serialVersionUID = 1L;
  private String userId;
  private String firstName;
  private String lastName;
  private String grade;
  private String email;
  private String password;
  private String encryptedPassword;
  private String emailVerificationToken;
  private Boolean emailVerificationStatus = false;
}
