package io.arfin.expensetracker.services;

import io.arfin.expensetracker.entities.Expense;
import io.arfin.expensetracker.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    @Override
    public List<Expense> getAllExpenses(Pageable pageable) {
        return expenseRepository.findAll(pageable).toList();
    }

    @Override
    public Expense getExpenseById(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        if(expense.isPresent()){
            return expense.get();
        }
        else {
            throw new RuntimeException("Expense not found with id: " + id);
        }
    }

    @Override
    public void deleteExpense(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        if(expense.isPresent()){
            expenseRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Expense not found with id: " + id);
        }
    }

    @Override
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense updateExpenseById(Expense expense, Long id) {
        Expense existingExpense = getExpenseById(id);
        existingExpense.setName(expense.getName() != null ? expense.getName() : existingExpense.getName());
        existingExpense.setAmount(expense.getAmount() != null ? expense.getAmount() : existingExpense.getAmount());
        existingExpense.setCategory(expense.getCategory() != null ? expense.getCategory() : existingExpense.getCategory());
        existingExpense.setDescription(expense.getDescription() != null ? expense.getDescription() : existingExpense.getDescription());
        existingExpense.setDate(expense.getDate() != null ? expense.getDate() : existingExpense.getDate());
        return saveExpense(existingExpense);
    }
}
