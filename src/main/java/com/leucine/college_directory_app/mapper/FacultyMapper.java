package com.leucine.college_directory_app.mapper;

import com.leucine.college_directory_app.dto.FacultyProfileDTO;
import com.leucine.college_directory_app.dto.StudentProfileDTO;
import com.leucine.college_directory_app.entity.FacultyProfile;
import com.leucine.college_directory_app.entity.StudentProfile;

public class FacultyMapper {
    public static FacultyProfileDTO mapToFacultyProfileDTO(FacultyProfile facultyProfile){

        return FacultyProfileDTO.builder()
                .userId(facultyProfile.getUserId())
                .photo(facultyProfile.getPhoto())
                .department(DepartmentMapper.mapToDepartmentDTO(facultyProfile.getDepartment()))
                .officeHours(facultyProfile.getOfficeHours())
                .user(UserMapper.mapToUserDTO(facultyProfile.getUser()))
                .build();
    }

    public static FacultyProfile mapToFacultyProfile(FacultyProfileDTO facultyProfileDTO){
        return FacultyProfile.builder()
                .userId(facultyProfileDTO.getUserId())
                .photo(facultyProfileDTO.getPhoto())
                .department(DepartmentMapper.mapToDepartment(facultyProfileDTO.getDepartment()))
                .officeHours(facultyProfileDTO.getOfficeHours())
                .user(UserMapper.mapToUser(facultyProfileDTO.getUser()))
                .build();
    }
}
