package com.gestaoCash.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.gestaoCash.model.Expense;
import com.gestaoCash.model.Revenue;

public interface ExpenseService {
  void saveExpense(Expense expense);
  
  List<Expense> findExpenseAndUser(Long id);

  List<Expense> findAllExpense();

  Expense findExpenseById(Long id);

  void updateExpenseById(Long id, Expense updatedExpense);

  void deleteExpenseById(Long id);
}
