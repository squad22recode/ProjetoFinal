package com.gestaocash.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestaocash.model.Expense;

@Repository
public interface ExpenseRespository extends JpaRepository<Expense, Long> {

}
