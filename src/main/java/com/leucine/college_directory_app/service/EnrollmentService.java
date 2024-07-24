package com.leucine.college_directory_app.service;

import com.leucine.college_directory_app.dto.StudentProfileDTO;

import java.util.List;

public interface EnrollmentService {
     List<StudentProfileDTO> getStudentsByFacultyUserId(Long facultyUserId);

}
