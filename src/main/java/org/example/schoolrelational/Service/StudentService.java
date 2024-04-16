package org.example.schoolrelational.Service;

import lombok.RequiredArgsConstructor;
import org.example.schoolrelational.Api.ApiException;
import org.example.schoolrelational.Model.Course;
import org.example.schoolrelational.Model.Student;
import org.example.schoolrelational.Repository.CourseRepository;
import org.example.schoolrelational.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository ;
    private final CourseRepository courseRepository ;


    public List<Student> get(){
        return studentRepository.findAll();
    }


    public void addStudent(Student student){

        studentRepository.save(student);
    }


    public void updateStudent(Integer Id , Student student){

        Student s = studentRepository.findStudentById(Id);

        if (s == null){
            throw new ApiException("Invalid Id");
        }

        s.setName(student.getName());
        s.setAge(student.getAge());
        s.setMajor(student.getMajor());
        s.setMajor(student.getMajor());

        studentRepository.save(s);


    }




    public void deleteStudent(Integer Id){


        Student s = studentRepository.findStudentById(Id);

        if (s == null){
            throw new ApiException("Invalid Id");
        }


        studentRepository.delete(s);

    }

    public void Major(Integer id , String major){
        Student student = studentRepository.findStudentById(id);

        if (student == null){
            throw new ApiException("Invalid Id");
        }

        student.setCourses(null);
        student.setMajor(major);
        studentRepository.save(student);
    }



    public void assignStudentToCourse(Integer student_id,Integer course_id){
        Student s=studentRepository.findStudentById(student_id);
        Course c=courseRepository.findCourseById(course_id);

        if(c==null|| s==null){
            throw new ApiException("cant assign");
        }
        s.getCourses().add(c);
        c.getStudent().add(s);

        courseRepository.save(c);
        studentRepository.save(s);
    }

}
