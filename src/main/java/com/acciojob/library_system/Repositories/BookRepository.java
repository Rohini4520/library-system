package com.acciojob.library_system.Repositories;

import com.acciojob.library_system.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
