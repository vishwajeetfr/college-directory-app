package com.leucine.college_directory_app.controller;

import com.leucine.college_directory_app.dto.StudentProfileDTO;
import com.leucine.college_directory_app.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;
    @PostMapping
    public ResponseEntity<StudentProfileDTO> createStudentProfile(@Valid @RequestBody StudentProfileDTO studentProfileDTO){
        final var savedStudent = studentService.createStudentProfile(studentProfileDTO);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<StudentProfileDTO> getStudentProfileById(@PathVariable("id") Long studentProfileId){
        final var studentProfile = studentService.getStudentProfileById(studentProfileId);
        return ResponseEntity.ok(studentProfile);
    }

    @GetMapping
    public ResponseEntity<List<StudentProfileDTO>> getAllStudentProfiles(){
        List<StudentProfileDTO> studentProfiles = studentService.getAllStudentProfiles();
        return ResponseEntity.ok (studentProfiles);
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentProfileDTO> updateStudentProfile(@PathVariable("id") Long studentProfileId,
                                              @RequestBody StudentProfileDTO studentProfileDTO){
        final var updatedStudentProfile = studentService.updateStudentProfile(studentProfileId,studentProfileDTO);
        return ResponseEntity.ok (updatedStudentProfile);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudentProfile(@PathVariable("id") Long studentProfileId){
        studentService.deleteStudentProfile(studentProfileId);
        return ResponseEntity.ok("Student profile has been deleted Successfully!");
    }

}
