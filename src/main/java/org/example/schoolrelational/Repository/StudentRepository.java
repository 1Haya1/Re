package org.example.schoolrelational.Repository;

import org.example.schoolrelational.Model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository {

    Student findStudentById(Integer id);
}
