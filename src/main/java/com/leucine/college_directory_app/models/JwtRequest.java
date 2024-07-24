package com.leucine.college_directory_app.models;

import lombok.*;

@Builder(toBuilder = true)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JwtRequest {
    private String userName;
    private String password;
}
