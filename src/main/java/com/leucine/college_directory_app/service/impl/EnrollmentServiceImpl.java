package com.leucine.college_directory_app.service.impl;

import com.leucine.college_directory_app.dto.StudentProfileDTO;
import com.leucine.college_directory_app.dto.UserDTO;
import com.leucine.college_directory_app.entity.Enrollment;
import com.leucine.college_directory_app.repository.EnrollmentRepository;
import com.leucine.college_directory_app.repository.UserRepository;
import com.leucine.college_directory_app.service.EnrollmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    private EnrollmentRepository enrollmentRepository;

    @Override
    public List<StudentProfileDTO> getStudentsByFacultyUserId(Long facultyUserId) {
        List<Enrollment> enrollments = enrollmentRepository.findByCourse_Faculty_User_Id(facultyUserId);
        return enrollments.stream()
                .map(enrollment -> StudentProfileDTO.builder()
                        .user(UserDTO.builder()
                                .name(enrollment.getStudent().getUser().getName())
                                .email(enrollment.getStudent().getUser().getEmail())
                                .phone(enrollment.getStudent().getUser().getPhone())
                                .build())
                        .photo(enrollment.getStudent().getPhoto())
                        .build())
                .collect(Collectors.toList());
    }
}
