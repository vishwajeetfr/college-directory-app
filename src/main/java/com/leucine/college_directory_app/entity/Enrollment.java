package com.leucine.college_directory_app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Enrollment")
@Data
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id", nullable = false)
    private StudentProfile student;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}

