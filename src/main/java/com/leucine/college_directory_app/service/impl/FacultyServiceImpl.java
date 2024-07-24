package com.leucine.college_directory_app.service.impl;

import com.leucine.college_directory_app.dto.FacultyProfileDTO;
import com.leucine.college_directory_app.entity.FacultyProfile;
import com.leucine.college_directory_app.entity.StudentProfile;
import com.leucine.college_directory_app.mapper.FacultyMapper;
import com.leucine.college_directory_app.mapper.StudentMapper;
import com.leucine.college_directory_app.repository.FacultyProfileRepository;
import com.leucine.college_directory_app.service.FacultyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FacultyServiceImpl implements FacultyService {
    private FacultyProfileRepository facultyProfileRepository;
    @Override
    public FacultyProfileDTO createFacultyProfile(FacultyProfileDTO facultyProfileDTO) {
        final var facultyProfile = FacultyMapper.mapToFacultyProfile(facultyProfileDTO);
        final var savedFaculty = facultyProfileRepository.save(facultyProfile);
        return FacultyMapper.mapToFacultyProfileDTO(savedFaculty);
    }

    @Override
    public List<FacultyProfileDTO> getAllFacultyProfiles() {
        List<FacultyProfile> faculties = facultyProfileRepository.findAll();
        return faculties.stream().map(e -> FacultyMapper.mapToFacultyProfileDTO(e)).collect(Collectors.toList());
    }
}
