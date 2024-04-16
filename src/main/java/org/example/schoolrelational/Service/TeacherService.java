package org.example.schoolrelational.Service;

import lombok.RequiredArgsConstructor;
import org.example.schoolrelational.Api.ApiException;
import org.example.schoolrelational.Model.Teacher;
import org.example.schoolrelational.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){

        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id,Teacher teacher){
        Teacher t=teacherRepository.findTeacherById(id);
        if(t==null){
            throw new ApiException("not found");
        }
        t.setName(teacher.getName());
        t.setAge(teacher.getAge());
        t.setEmail(teacher.getEmail());
        t.setSalary(teacher.getSalary());
        teacherRepository.save(t);
    }

    public void deleteTeacher(Integer id){
        Teacher t=teacherRepository.findTeacherById(id);
        if (t==null){
            throw new ApiException("not found");
        }
        teacherRepository.delete(t);
    }

    public Teacher getTeacherById(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher==null){
            throw new ApiException("not found");
        }
        return teacher ;
    }


}
