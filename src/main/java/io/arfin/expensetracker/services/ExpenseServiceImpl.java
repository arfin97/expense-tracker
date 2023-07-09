package io.arfin.expensetracker.services;

import io.arfin.expensetracker.entities.Expense;
import io.arfin.expensetracker.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
}
