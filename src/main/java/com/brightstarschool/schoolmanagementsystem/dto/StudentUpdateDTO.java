package com.brightstarschool.schoolmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentUpdateDTO {
    private long studentId;

    @NotNull
    private String studentName;

    @NotNull
    private String adress;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String email;

    @NotNull
    private long idNumber;

    @NonNull
    private String password;
}
