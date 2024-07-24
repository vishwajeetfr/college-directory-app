package com.leucine.college_directory_app.service;


import com.leucine.college_directory_app.dto.StudentProfileDTO;

import java.util.List;

public interface StudentService {
    StudentProfileDTO createStudentProfile(StudentProfileDTO studentProfileDto);
    StudentProfileDTO getStudentProfileById(Long studentProfileId);
    StudentProfileDTO getStudentProfileByStudentUserName(String username);
    List<StudentProfileDTO> getAllStudentProfiles();
    List<StudentProfileDTO> getStudentProfilesByYear(String year);
    StudentProfileDTO updateStudentProfile(Long studentProfileId, StudentProfileDTO updatedStudentProfileDto);

    void deleteStudentProfile(Long studentProfileId);
}
