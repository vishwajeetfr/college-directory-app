package com.leucine.college_directory_app.entity;

import jakarta.persistence.*;
import lombok.*;


@Builder(toBuilder = true)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AdministratorProfile")
public class AdministratorProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String photo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
