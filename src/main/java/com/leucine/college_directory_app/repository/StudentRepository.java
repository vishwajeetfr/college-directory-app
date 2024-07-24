package com.leucine.college_directory_app.repository;

import com.leucine.college_directory_app.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentProfile, Long> {
}
