package com.leucine.college_directory_app.mapper;

import com.leucine.college_directory_app.dto.DepartmentDTO;
import com.leucine.college_directory_app.dto.StudentProfileDTO;
import com.leucine.college_directory_app.entity.Department;
import com.leucine.college_directory_app.entity.StudentProfile;

public class DepartmentMapper {
    public static DepartmentDTO mapToDepartmentDTO(Department department){
        return DepartmentDTO.builder()
                .id(department.getId())
                .name(department.getName())
                .description(department.getDescription())
                .build();
    }

    public static Department mapToDepartment(DepartmentDTO departmentDTO){
        return Department.builder()
                .id(departmentDTO.getId())
                .name(departmentDTO.getName())
                .description(departmentDTO.getDescription())
                .build();
    }
}
