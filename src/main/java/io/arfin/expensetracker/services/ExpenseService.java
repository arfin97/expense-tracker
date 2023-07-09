package io.arfin.expensetracker.services;

import io.arfin.expensetracker.entities.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses(Pageable pageable);
    Expense getExpenseById(Long id);
    void deleteExpense(Long id);

    Expense saveExpense(Expense expense);

    Expense updateExpenseById(Expense expense, Long id);
}
