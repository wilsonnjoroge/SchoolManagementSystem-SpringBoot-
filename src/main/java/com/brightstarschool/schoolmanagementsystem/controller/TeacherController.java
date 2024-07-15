package com.brightstarschool.schoolmanagementsystem.controller;

import com.brightstarschool.schoolmanagementsystem.dto.*;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @PostMapping(path = "/add-teachers")
    public String saveTeacher(@RequestBody TeacherSaveDTO teacherSaveDTO)
    {
        String teacherName = teacherService.addTeacher(teacherSaveDTO);
        return "Name: " + teacherName;
    };

    @GetMapping(path = "/view-all-teachers")
    public List<TeacherDTO> getAllTeachers()
    {
        List<TeacherDTO> allTeachers = teacherService.getAllTeachers();
        return allTeachers;
    };

    @PutMapping(path = "/update-teacher/{id}")
    public String updateTeacher(@PathVariable("id") long id, @RequestBody TeacherUpdateDTO teacherUpdateDTO) {
        String updatedTeacher = teacherService.updateTeacher(id, teacherUpdateDTO);
        return updatedTeacher;
    }

    @DeleteMapping(path = "/delete-teacher/{id}")
    public String deleteTeacher(@PathVariable("id") long id) {
        boolean deleteTeacher = teacherService.deleteTeacher(id);
        if (deleteTeacher) {
            return "Teacher deleted successfully";
        } else {
            return "Teacher ID not found";
        }
    }
}
