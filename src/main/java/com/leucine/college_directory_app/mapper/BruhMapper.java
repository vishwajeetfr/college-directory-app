package com.leucine.college_directory_app.mapper;

import com.leucine.college_directory_app.dto.BruhDto;
import com.leucine.college_directory_app.entity.Bruh;

public class BruhMapper {
    public static BruhDto mapToBruhDto(Bruh bruh){
        return new BruhDto(
                bruh.getId(),
                bruh.getLocation()
        );
    }

    public static Bruh mapToBruh(BruhDto bruhDto){
        return new Bruh(
                bruhDto.getId(),
                bruhDto.getLocation()
        );
    }
}
