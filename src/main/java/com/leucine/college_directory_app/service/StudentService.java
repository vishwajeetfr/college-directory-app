package com.leucine.college_directory_app.service;


import com.leucine.college_directory_app.dto.StudentProfileDTO;

import java.util.List;

public interface StudentService {
    StudentProfileDTO createStudentProfile(StudentProfileDTO studentProfileDto);
    StudentProfileDTO getStudentProfileById(Long studentProfileId);
    List<StudentProfileDTO> getAllStudentProfiles();
    StudentProfileDTO updateStudentProfile(Long studentProfileId, StudentProfileDTO updatedStudentProfileDto);

    void deleteStudentProfile(Long studentProfileId);
}
