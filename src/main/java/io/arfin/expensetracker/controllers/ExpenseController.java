package io.arfin.expensetracker.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    @GetMapping("/expenses")
    public String getAllExpenses(){
        return "All Expenses";
    }
}
