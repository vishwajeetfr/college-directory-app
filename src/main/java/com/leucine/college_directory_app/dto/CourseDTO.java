package com.leucine.college_directory_app.dto;

import lombok.*;

@Builder(toBuilder = true)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private DepartmentDTO department;
    private FacultyProfileDTO faculty;
}

