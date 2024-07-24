package com.leucine.college_directory_app.service.impl;

import com.leucine.college_directory_app.dto.StudentProfileDTO;
import com.leucine.college_directory_app.dto.UserDTO;
import com.leucine.college_directory_app.entity.StudentProfile;
import com.leucine.college_directory_app.entity.User;
import com.leucine.college_directory_app.exception.ResourceNotFoundExeception;
import com.leucine.college_directory_app.mapper.DepartmentMapper;
import com.leucine.college_directory_app.mapper.StudentMapper;
import com.leucine.college_directory_app.mapper.UserMapper;
import com.leucine.college_directory_app.repository.StudentRepository;
import com.leucine.college_directory_app.repository.UserRepository;
import com.leucine.college_directory_app.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private UserRepository userRepository;

    @Override
    public StudentProfileDTO createStudentProfile(StudentProfileDTO studentProfileDto) {
        final var studentProfile = StudentMapper.mapToStudentProfile(studentProfileDto);

        final var savedStudent = studentRepository.save(studentProfile);
        return StudentMapper.mapToStudentProfileDTO(savedStudent);
    }

    @Override
    public StudentProfileDTO getStudentProfileById(Long studentProfileId) {
        final var student = studentRepository.findById(studentProfileId).orElseThrow(() ->
                new ResourceNotFoundExeception("Student profile not exists with id :" + studentProfileId.toString()));
        return StudentMapper.mapToStudentProfileDTO(student);
    }
    @Override
    public StudentProfileDTO getStudentProfileByStudentUserName(String username) {
        final var student = studentRepository.findByUserUsername(username).orElseThrow(() ->
                new ResourceNotFoundExeception("Student profile not exists with username :" + username));
        return StudentMapper.mapToStudentProfileDTO(student);
    }

    @Override
    public List<StudentProfileDTO> getStudentProfileByStudentName(String name) {
        final var students = studentRepository.findByUserName(name).orElseThrow(() ->
                new ResourceNotFoundExeception("Student profiles not exists with name :" + name));
        return students.stream().map(e -> StudentMapper.mapToStudentProfileDTO(e)).collect(Collectors.toList());
    }

    @Override
    public List<StudentProfileDTO> getStudentProfileByDepartmentName(String name) {
        final var students = studentRepository.findByDepartmentName(name).orElseThrow(() ->
                new ResourceNotFoundExeception("Student profiles not exists with department name :" + name));
        return students.stream().map(e -> StudentMapper.mapToStudentProfileDTO(e)).collect(Collectors.toList());
    }

    @Override
    public List<StudentProfileDTO> getStudentProfilesByUserNameDepartmentNameYear(String name,
                                                                                  String departmentName,
                                                                                  String year) {
        final var students = studentRepository.findByUserNameAndDepartmentNameAndYear(name,departmentName,year).orElseThrow(() ->
                new ResourceNotFoundExeception("Student profiles not exists with filter criteria name :" + name +
                        ", departmentName" + departmentName + " and year : "+ year));
        return students.stream().map(e -> StudentMapper.mapToStudentProfileDTO(e)).collect(Collectors.toList());
    }


    @Override
    public List<StudentProfileDTO> getAllStudentProfiles() {
        List<StudentProfile> students = studentRepository.findAll();
        return students.stream().map(e -> StudentMapper.mapToStudentProfileDTO(e)).collect(Collectors.toList());
    }

    @Override
    public List<StudentProfileDTO> getStudentProfilesByYear(String year) {
        List<StudentProfile> students = studentRepository.findAllByYear(year);
        return students.stream().map(e -> StudentMapper.mapToStudentProfileDTO(e)).collect(Collectors.toList());
    }

    @Override
    public StudentProfileDTO updateStudentProfile(Long studentProfileId, StudentProfileDTO updatedStudentProfileDto) {

        final var student = studentRepository.findById(studentProfileId)
                .orElseThrow(() -> new ResourceNotFoundExeception("Student profile not exists with id : " + studentProfileId.toString()));
        // student.setUserId(updatedStudentProfileDto.getUserId());
        student.setPhoto(updatedStudentProfileDto.getPhoto());
        student.setDepartment(DepartmentMapper.mapToDepartment(updatedStudentProfileDto.getDepartment()));
        student.setYear(updatedStudentProfileDto.getYear());

        User existingUser = student.getUser();
        UserDTO userDTO = updatedStudentProfileDto.getUser();

        // Check if the email already exists and belongs to a different user
        Optional<User> existingUserByEmail = userRepository.findByEmail(updatedStudentProfileDto.getUser().getEmail());
        if (existingUserByEmail.isPresent() && !existingUserByEmail.get().getId().equals(student.getUser().getId())) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Check if the username already exists and belongs to a different user
        Optional<User> existingUserByUsername = userRepository.findByUsername(updatedStudentProfileDto.getUser().getUsername());
        if (existingUserByUsername.isPresent() && !existingUserByUsername.get().getId().equals(student.getUser().getId())) {
            throw new IllegalArgumentException("Username already exists");
        }

        existingUser.setUsername(userDTO.getUsername());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setName(userDTO.getName());
        existingUser.setPassword(userDTO.getPassword());
        existingUser.setRole(userDTO.getRole());
        existingUser.setPhone(userDTO.getPhone());

        final var updatedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentProfileDTO(updatedStudent);
    }

    @Override
    public void deleteStudentProfile(Long studentProfileId) {
        final var student = studentRepository.findById(studentProfileId)
                .orElseThrow(() -> new ResourceNotFoundExeception("Student profile not exists with id : " + studentProfileId.toString()));
        studentRepository.deleteById(studentProfileId);
    }
}
