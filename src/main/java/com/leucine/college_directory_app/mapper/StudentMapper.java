package com.leucine.college_directory_app.mapper;

import com.leucine.college_directory_app.dto.StudentProfileDTO;
import com.leucine.college_directory_app.entity.StudentProfile;

public class StudentMapper {
    public static StudentProfileDTO mapToStudentProfileDTO(StudentProfile studentProfile){
        return StudentProfileDTO.builder()
                .userId(studentProfile.getUserId())
                .photo(studentProfile.getPhoto())
                .department(DepartmentMapper.mapToDepartmentDTO(studentProfile.getDepartment()))
                .year(studentProfile.getYear())
                .user(UserMapper.mapToUserDTO(studentProfile.getUser()))
                .build();
    }

    public static StudentProfile mapToStudentProfile(StudentProfileDTO studentProfileDTO){

        return StudentProfile.builder()
                .userId(studentProfileDTO.getUserId())
                .photo(studentProfileDTO.getPhoto())
                .department(DepartmentMapper.mapToDepartment(studentProfileDTO.getDepartment()))
                .year(studentProfileDTO.getYear())
                .user(UserMapper.mapToUser(studentProfileDTO.getUser()))
                .build();
    }
}
