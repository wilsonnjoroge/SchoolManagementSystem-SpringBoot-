package com.brightstarschool.schoolmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeesPerTermUpdateDTO {
    private long term;
    private long feeCharged;
}
