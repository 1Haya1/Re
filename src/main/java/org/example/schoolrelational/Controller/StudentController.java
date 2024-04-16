package org.example.schoolrelational.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.schoolrelational.Api.ApiResponse;
import org.example.schoolrelational.Model.Student;
import org.example.schoolrelational.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {


   private final StudentService studentService;


    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(studentService.get());
    }



    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student){

        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added"));

    }




    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id , @RequestBody @Valid Student student){

        studentService.updateStudent(id, student);

        return ResponseEntity.status(200).body(new ApiResponse("Student updated"));
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){

        studentService.deleteStudent(id);

        return ResponseEntity.status(200).body(new ApiResponse("Student deleted"));
    }







    @GetMapping("/change/{id}/{major}")
    public ResponseEntity Major(@PathVariable Integer id , @PathVariable String major){
        studentService.Major(id, major);

        return ResponseEntity.status(200).body(new ApiResponse("Student updated"));
    }





    @PutMapping("/assign/{student_id}/{course_id}")//ربطهم
    public ResponseEntity assignStudentToCourse(@PathVariable Integer student_id,@PathVariable Integer course_id){
        studentService.assignStudentToCourse(student_id,course_id);
        return ResponseEntity.status(200).body(new ApiResponse("assign done"));
    }

}
