package com.leucine.college_directory_app.controller;

import com.leucine.college_directory_app.dto.StudentProfileDTO;
import com.leucine.college_directory_app.service.EnrollmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/faculty")
public class FacultyController {
    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/{facultyId}/students")
    @PreAuthorize("hasRole('FACULTY') || hasRole('ADMIN')")
    public ResponseEntity<List<StudentProfileDTO>> getStudentsByFacultyId(@PathVariable("facultyId") Long facultyUserId) {
        List<StudentProfileDTO> students = enrollmentService.getStudentsByFacultyUserId(facultyUserId);
        return ResponseEntity.ok(students);
    }
}
