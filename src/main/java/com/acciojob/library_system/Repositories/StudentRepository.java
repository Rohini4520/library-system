package com.acciojob.library_system.Repositories;

import com.acciojob.library_system.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
