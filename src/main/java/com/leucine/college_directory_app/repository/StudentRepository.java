package com.leucine.college_directory_app.repository;

import com.leucine.college_directory_app.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentProfile, Long> {
    @Query("SELECT sp FROM StudentProfile sp WHERE sp.user.username = :username")
    Optional<StudentProfile> findByUserUsername(@Param("username") String username);
    List<StudentProfile> findAllByYear(String year);
}
