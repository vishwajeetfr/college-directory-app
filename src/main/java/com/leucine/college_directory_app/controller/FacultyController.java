package com.leucine.college_directory_app.controller;

import com.leucine.college_directory_app.dto.FacultyProfileDTO;
import com.leucine.college_directory_app.dto.StudentProfileDTO;
import com.leucine.college_directory_app.service.EnrollmentService;
import com.leucine.college_directory_app.service.FacultyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/faculty")
public class FacultyController {
    @Autowired
    private EnrollmentService enrollmentService;
    @Autowired
    private FacultyService facultySercvie;

    @GetMapping("/{facultyId}/students")
    @PreAuthorize("hasRole('FACULTY') || hasRole('ADMIN')")
    public ResponseEntity<List<StudentProfileDTO>> getStudentsByFacultyId(@PathVariable("facultyId") Long facultyUserId) {
        List<StudentProfileDTO> students = enrollmentService.getStudentsByFacultyUserId(facultyUserId);
        return ResponseEntity.ok(students);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public ResponseEntity<FacultyProfileDTO> createFacultyProfile(@RequestBody FacultyProfileDTO facultyProfileDTO) {
        final var profile = facultySercvie.createFacultyProfile(facultyProfileDTO);
        return new ResponseEntity<>(profile, HttpStatus.CREATED);
    }

    @GetMapping
    @PreAuthorize("hasRole('FACULTY_MEMBER') || hasRole('ADMINISTRATOR')")
    public ResponseEntity<List<FacultyProfileDTO>> getAllFacultyMembers(){
        List<FacultyProfileDTO> facultyProfiles = facultySercvie.getAllFacultyProfiles();
        return ResponseEntity.ok (facultyProfiles);
    }
}
