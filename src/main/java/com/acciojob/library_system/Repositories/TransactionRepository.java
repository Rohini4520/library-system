package com.acciojob.library_system.Repositories;


import com.acciojob.library_system.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
