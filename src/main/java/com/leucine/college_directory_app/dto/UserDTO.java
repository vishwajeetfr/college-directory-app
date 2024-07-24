package com.leucine.college_directory_app.dto;

import com.leucine.college_directory_app.entity.Role;
import lombok.*;

@Builder(toBuilder = true)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private Role role;
    private String name;
    private String email;
    private String phone;
}

