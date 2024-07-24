package com.leucine.college_directory_app.service.impl;

import com.leucine.college_directory_app.dto.BruhDto;
import com.leucine.college_directory_app.entity.Bruh;
import com.leucine.college_directory_app.exception.ResourceNotFoundExeception;
import com.leucine.college_directory_app.mapper.BruhMapper;
import com.leucine.college_directory_app.repository.BruhRepository;
import com.leucine.college_directory_app.service.BruhService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BruhServiceImpl implements BruhService {
    private BruhRepository bruhRepository;
    @Override
    public BruhDto createBruh(BruhDto bruhDto) {
        Bruh bruh = BruhMapper.mapToBruh(bruhDto);
        Bruh savedBruh = bruhRepository.save(bruh);
        return BruhMapper.mapToBruhDto(savedBruh);
    }

    @Override
    public BruhDto getBruhById(Long bruhId) {
        Bruh bruh = bruhRepository.findById(bruhId).orElseThrow(() ->
                new ResourceNotFoundExeception("Bruh not exists with given id :" + bruhId));
        return BruhMapper.mapToBruhDto(bruh);
    }

    @Override
    public List<BruhDto> getAllBruhs() {
        List<Bruh> bruhs = bruhRepository.findAll();
       return bruhs.stream().map(e -> BruhMapper.mapToBruhDto(e)).collect(Collectors.toList());
    }

    @Override
    public BruhDto updateBruh(Long bruhId, BruhDto updatedBruhDto) {
        Bruh bruh = bruhRepository.findById(bruhId)
                .orElseThrow(() -> new ResourceNotFoundExeception("bruh does not exist" + bruhId));

        bruh.setLocation(updatedBruhDto.getLocation());
        Bruh updatedBruh = bruhRepository.save(bruh);
        return BruhMapper.mapToBruhDto(updatedBruh);
    }

    @Override
    public void deleteBruh(Long bruhId) {
        Bruh bruh = bruhRepository.findById(bruhId)
                .orElseThrow(() -> new ResourceNotFoundExeception("bruh does not exist" + bruhId));
        bruhRepository.deleteById(bruhId);
    }
}
