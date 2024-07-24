package com.leucine.college_directory_app.service;

import com.leucine.college_directory_app.dto.FacultyProfileDTO;
import com.leucine.college_directory_app.dto.StudentProfileDTO;

import java.util.List;

public interface FacultyService {
    FacultyProfileDTO createFacultyProfile(FacultyProfileDTO facultyProfileDTO);
    List<FacultyProfileDTO> getAllFacultyProfiles();
}
