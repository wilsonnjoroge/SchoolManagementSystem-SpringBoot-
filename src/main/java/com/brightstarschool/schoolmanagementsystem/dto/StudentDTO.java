package com.brightstarschool.schoolmanagementsystem.dto;

import com.brightstarschool.schoolmanagementsystem.entity.Dormitory;
import com.brightstarschool.schoolmanagementsystem.entity.FeesPerTerm;
import com.brightstarschool.schoolmanagementsystem.entity.Stream;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private long studentId;
    private String admissionNumber;
    private String name;
    private String adress;
    private long phoneNumber;
    private String email;
    private long idNumber;
    private Stream stream;
    private Dormitory dormitory;
    private FeesPerTerm currentTerm;
    private long totalFeeBilled;
    private long totalPaidFee;
    private long feeBalance;
    private String accessToken;
    private String resetToken;
    private boolean isEmailVerified;
    private boolean isDeleted;
}
