package com.leucine.college_directory_app.dto;

import lombok.*;

@Builder(toBuilder = true)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacultyProfileDTO {
    private Long userId;
    private String photo;
    private DepartmentDTO department;
    private String officeHours;
    private UserDTO user;
}

