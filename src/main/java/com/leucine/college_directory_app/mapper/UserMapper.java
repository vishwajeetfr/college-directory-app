package com.leucine.college_directory_app.mapper;

import com.leucine.college_directory_app.dto.UserDTO;
import com.leucine.college_directory_app.entity.User;

public class UserMapper {

    public static UserDTO mapToUserDTO(User user){
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }

    public static User mapToUser(UserDTO userDTO){
        return User.builder()
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .role(userDTO.getRole())
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .phone(userDTO.getPhone())
                .build();
    }

}
