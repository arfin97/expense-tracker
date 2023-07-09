package io.arfin.expensetracker.services;

import io.arfin.expensetracker.entities.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();
}
