package org.example.schoolrelational.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.schoolrelational.Api.ApiResponse;
import org.example.schoolrelational.Model.Teacher;
import org.example.schoolrelational.Service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;


    @GetMapping("/get")
    public ResponseEntity getAllTeacher(){
        return ResponseEntity.status(200).body(teacherService.getAllTeacher());
    }



    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher ){

        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher added"));

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id , @RequestBody @Valid Teacher teacher){

        teacherService.updateTeacher(id, teacher);

        return ResponseEntity.status(200).body(new ApiResponse("Teacher updated"));
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){

        teacherService.deleteTeacher(id);

        return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted"));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getTeacherById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getTeacherById(id));
    }


}
