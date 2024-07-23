package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.StudentSaveDTO;
import com.brightstarschool.schoolmanagementsystem.Utils.EmailsManagement;
import com.brightstarschool.schoolmanagementsystem.entity.Student;
import com.brightstarschool.schoolmanagementsystem.repository.StudentRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.AuthenticationStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class AuthenticationStudentServiceImplementation implements AuthenticationStudent {
    private StudentRepository studentRepository;
    private PasswordEncoder  passwordEncoder;
    private EmailsManagement emailsManagement;

    @Autowired
    public AuthenticationStudentServiceImplementation(StudentRepository studentRepository,
                                                      PasswordEncoder passwordEncoder,
                                                      EmailsManagement emailsManagement) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailsManagement = emailsManagement;
    }

    @Override
    public String addStudent(StudentSaveDTO studentSaveDTO) {
        try {

            Optional<Student> studentIdExist = studentRepository.findByIdNumber(studentSaveDTO.getIdNumber());

            if(studentIdExist.isPresent())
            {
                return ("Student with id: " + studentSaveDTO.getIdNumber() + " already exists!!");
            };

            Optional<Student> studentEmailExist = studentRepository.findByEmail(studentSaveDTO.getEmail());
            if(studentEmailExist.isPresent())
            {
                return ( "Student with email: " + studentSaveDTO.getEmail() + " already exists!!");
            }

            String encodedPassword = passwordEncoder.encode(studentSaveDTO.getPassword());

            Student student = new Student(
                    studentSaveDTO.getName(),
                    studentSaveDTO.getAdress(),
                    studentSaveDTO.getPhoneNumber(),
                    studentSaveDTO.getEmail(),
                    studentSaveDTO.getIdNumber(),
                    encodedPassword,
                    ""
            );

            studentRepository.save(student);

            String emailBody = "Dear " + studentSaveDTO.getName() + ", \nWelcome to Bright Star School. We are pleased to have you aboard.";
            emailsManagement.sendEmail(studentSaveDTO.getEmail(),"Registration Successfull", emailBody);

            return student.getName();

        } catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }

    }

}
