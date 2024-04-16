package org.example.schoolrelational.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.schoolrelational.Api.ApiResponse;
import org.example.schoolrelational.Model.Course;
import org.example.schoolrelational.Model.Student;
import org.example.schoolrelational.Service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RequiredArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCourse(){
        return ResponseEntity.status(200).body(courseService.getAllCourse());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @RequestBody @Valid Course course){
        courseService.updateCourse(id,course);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }


    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @PutMapping("/assign/{teacher_id}/{course_id}")//ربطهم
    public ResponseEntity assignTeacherToCourse(@PathVariable Integer teacher_id,@PathVariable Integer course_id){
        courseService.assignTeacherToCourse(teacher_id,course_id);
        return ResponseEntity.status(200).body(new ApiResponse("assign done"));
    }

    @GetMapping("/t/{course_id}")
    public ResponseEntity TeacherNameByCourseId(@PathVariable Integer course_id){
        String teacherName= courseService.TeacherNameByCourseId(course_id);
        return ResponseEntity.status(200).body(teacherName);
    }



    @GetMapping("/{course_id}/students")
    public List<Student> getStudentsByCourseId(@PathVariable Integer course_id) {
        return courseService.getStudentsByCourseId(course_id);
    }

}
