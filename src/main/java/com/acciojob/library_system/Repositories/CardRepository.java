package com.acciojob.library_system.Repositories;

import com.acciojob.library_system.Models.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<LibraryCard,Integer> {
}
