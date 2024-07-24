package com.leucine.college_directory_app.dto;

import lombok.*;

@Builder(toBuilder = true)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentDTO {
    private Long id;
    private StudentProfileDTO student;
    private CourseDTO course;
}
