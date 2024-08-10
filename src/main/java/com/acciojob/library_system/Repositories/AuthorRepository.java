package com.acciojob.library_system.Repositories;

import com.acciojob.library_system.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
