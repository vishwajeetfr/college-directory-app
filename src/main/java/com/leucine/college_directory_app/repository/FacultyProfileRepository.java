package com.leucine.college_directory_app.repository;

import com.leucine.college_directory_app.entity.FacultyProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyProfileRepository extends JpaRepository<FacultyProfile, Long> {
}
