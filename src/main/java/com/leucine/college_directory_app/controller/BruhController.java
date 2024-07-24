package com.leucine.college_directory_app.controller;

import com.leucine.college_directory_app.dto.BruhDto;
import com.leucine.college_directory_app.service.BruhService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/bruhs")
public class BruhController {
    private BruhService bruhService;
    @PostMapping
    public ResponseEntity<BruhDto> createBruh(@RequestBody BruhDto bruhDto){
       BruhDto savedBruh = bruhService.createBruh(bruhDto);
       return new ResponseEntity<>(savedBruh, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<BruhDto> getBruhById(@PathVariable("id") Long bruhId){
        BruhDto bruhDto = bruhService.getBruhById(bruhId);
        return ResponseEntity.ok(bruhDto);
    }

    @GetMapping
    public ResponseEntity<List<BruhDto>> getAllBruhs(){
        List<BruhDto> bruhs = bruhService.getAllBruhs();
        return ResponseEntity.ok (bruhs);
    }

    @PutMapping("{id}")
    public ResponseEntity<BruhDto> updateBruh(@PathVariable("id") Long bruhId,
                                              @RequestBody BruhDto bruhDto){
        BruhDto updatedBruh = bruhService.updateBruh(bruhId,bruhDto);
        return ResponseEntity.ok (updatedBruh);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBruh(@PathVariable("id") Long bruhId){
        bruhService.deleteBruh(bruhId);
        return ResponseEntity.ok("Bruh deleted Successfully!");
    }

}
