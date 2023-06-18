/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pft.model.ExpenseRepository;

import pft.model.IncomeRepository.IncomeService;

/**
 *
 * @author ishwar
 */
public class ExpenseMain {
    public static void main(String[] args) {
    ExpenseService<String> expenseService = new ExpenseService<>();
    expenseService.showMenu("i");
}

    
}
