package com.leucine.college_directory_app.repository;

import com.leucine.college_directory_app.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByCourse_Faculty_User_Id(Long facultyUserId);
}