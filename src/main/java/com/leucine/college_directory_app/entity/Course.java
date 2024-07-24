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
@Table(name = "Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "faculty_id", nullable = false)
    private FacultyProfile faculty;
}

