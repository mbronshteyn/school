package com.mbronshteyn.school.repository;

import com.mbronshteyn.school.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Long> {
  StudentEntity findStudentByEmail( String email );
}
