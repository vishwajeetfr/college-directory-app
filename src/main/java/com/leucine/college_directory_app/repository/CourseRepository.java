package com.leucine.college_directory_app.repository;

import com.leucine.college_directory_app.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}