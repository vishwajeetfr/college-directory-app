package com.leucine.college_directory_app.repository;

import com.leucine.college_directory_app.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentProfile, Long> {
    @Query("SELECT sp FROM StudentProfile sp WHERE sp.user.username = :username")
    Optional<StudentProfile> findByUserUsername(@Param("username") String username);

    @Query("SELECT sp FROM StudentProfile sp WHERE sp.user.name = :name")
    Optional<List<StudentProfile>> findByUserName(@Param("name") String name);

    @Query("SELECT sp FROM StudentProfile sp WHERE sp.department.name = :name")
    Optional<List<StudentProfile>> findByDepartmentName(@Param("name") String name);

    @Query("SELECT sp FROM StudentProfile sp WHERE  sp.user.name = :name AND sp.department.name = :departmentName AND sp.year=:year")
    Optional<List<StudentProfile>> findByUserNameAndDepartmentNameAndYear(@Param("name") String name,
                                                                          @Param("departmentName") String departmentName,
                                                                          @Param("year") String year);
    List<StudentProfile> findAllByYear(String year);
}
