package org.example.schoolrelational.Service;

import lombok.RequiredArgsConstructor;
import org.example.schoolrelational.Api.ApiException;
import org.example.schoolrelational.Model.Course;
import org.example.schoolrelational.Model.Student;
import org.example.schoolrelational.Model.Teacher;
import org.example.schoolrelational.Repository.CourseRepository;
import org.example.schoolrelational.Repository.StudentRepository;
import org.example.schoolrelational.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

   private final CourseRepository courseRepository;
   private final TeacherRepository teacherRepository;
   private final StudentRepository studentRepository;

    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }


    public void updateCourse(Integer id,Course course){
        Course c=courseRepository.findCourseById(id);
        if(c==null){
            throw new ApiException("not found");
        }
        c.setName(course.getName());


        courseRepository.save(c);
    }


    public void deleteCourse(Integer id){
        Course b=courseRepository.findCourseById(id);

        if(b==null){
            throw new ApiException("not found");
        }

        courseRepository.delete(b);
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }


    public void assignTeacherToCourse(Integer teacher_id,Integer course_id){ //ربطهم
        Teacher t=teacherRepository.findTeacherById(teacher_id);
        Course c=courseRepository.findCourseById(course_id);
        if(t==null || c==null){
            throw new ApiException("cant assign");
        }

        c.setTeacher(t);

        courseRepository.save(c);
    }


    public String TeacherNameByCourseId( Integer course_id){
        Course c=courseRepository.findCourseById(course_id);

        if(c==null){
            throw new ApiException("not found");
        }
        Teacher teacher = c.getTeacher();
        if (teacher == null) {
            throw new ApiException("No teacher assigned to the course with ID");
        }
        return teacher.getName();

    }


    public List<Student> getStudentsByCourseId(Integer course_id) {
        Course course = courseRepository.findCourseById(course_id);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        return course.getStudent();
    }



}
