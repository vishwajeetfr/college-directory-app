package com.leucine.college_directory_app.dto;

import com.leucine.college_directory_app.entity.Department;
import com.leucine.college_directory_app.entity.User;
import lombok.*;

@Builder(toBuilder = true)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfileDTO {
    private Long userId;
    private String photo;
    private DepartmentDTO department;
    private String year;
    private UserDTO user;
}
