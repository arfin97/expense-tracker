package io.arfin.expensetracker.services;

import io.arfin.expensetracker.entities.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);
    void deleteExpense(Long id);

    Expense saveExpense(Expense expense);

    Expense updateExpenseById(Expense expense, Long id);
}
