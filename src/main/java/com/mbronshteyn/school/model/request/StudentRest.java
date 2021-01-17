package com.mbronshteyn.school.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentRest {
  @JsonInclude(JsonInclude.Include.NON_NULL)
  String userId;
  String firstName;
  String lastName;
  String grade;
  String email;
  String password;
}
