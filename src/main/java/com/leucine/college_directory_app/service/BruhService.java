package com.leucine.college_directory_app.service;

import com.leucine.college_directory_app.dto.BruhDto;

import java.util.List;

public interface BruhService {
    BruhDto createBruh(BruhDto bruhDto);
    BruhDto getBruhById(Long bruhId);
    List<BruhDto> getAllBruhs();
    BruhDto updateBruh(Long bruhId, BruhDto updatedBruhDto);

    void deleteBruh(Long bruhId);
}
