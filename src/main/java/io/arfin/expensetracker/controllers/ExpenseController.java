package io.arfin.expensetracker.controllers;

import io.arfin.expensetracker.entities.Expense;
import io.arfin.expensetracker.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(Pageable pageable){
        return expenseService.getAllExpenses(pageable);
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable( name = "id") Long id){
        return expenseService.getExpenseById(id);
    }

    @DeleteMapping("/expenses")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteExpense(@RequestParam(name = "id") Long id){
        expenseService.deleteExpense(id);
    }

    @PostMapping("/expenses")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Expense saveExpense(@RequestBody Expense expense){
        return expenseService.saveExpense(expense);
    }

    @PutMapping("/expenses/{id}")
    public Expense updateExpenseById(@RequestBody Expense expense, @PathVariable Long id){
        return expenseService.updateExpenseById(expense, id);
    }
}
