package pft.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class IncomeExpenseService<T> implements IncomeExpenseDetails<T> {

    private List<Income<T>> incomeSources;
    private Scanner scanner;
    private DateTimeFormatter dateFormatter;
    private int nextId;

    public IncomeExpenseService() {
        incomeSources = new ArrayList<>();
        scanner = new Scanner(System.in);
        dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        nextId = 1;
    }

    @Override
    public void addIncome(T income, BigDecimal amount, LocalDate date) {
        Income<T> newIncome = new Income<>(income, amount, date, nextId);
        incomeSources.add(newIncome);
        nextId++;
    }

    @Override
    public void displayIncomeSources() {
        if (incomeSources.isEmpty()) {
            System.out.println("No income sources added.");
        } else {
            System.out.println("Income Sources:");
            for (Income<T> income : incomeSources) {
                System.out.println(income.id + " " + income.source + "  " + income.amount + " " + income.date.format(dateFormatter));

            }
        }
    }

    @Override
    public void deleteIncome(int id) {
        Income<T> incomeToRemove = null;
        for (Income<T> income : incomeSources) {
            if (income.id == id) {
                incomeToRemove = income;
                break;
            }
        }
        if (incomeToRemove != null) {
            incomeSources.remove(incomeToRemove);
            System.out.println("Income source with ID " + id + " deleted.");
        } else {
            System.out.println("Income source with ID " + id + " not found.");
        }
    }

    @Override
    public void updateIncome(int id, T newIncome, BigDecimal newAmount, LocalDate newDate) {
        Income<T> incomeToUpdate = null;
        for (Income<T> income : incomeSources) {
            if (income.id == id) {
                incomeToUpdate = income;
                break;
            }
        }
        if (incomeToUpdate != null) {
            incomeToUpdate.source = newIncome;
            incomeToUpdate.amount = newAmount;
            incomeToUpdate.date = newDate;
            System.out.println("Income source with ID " + id + " updated.");
        } else {
            System.out.println("Income source with ID " + id + " not found.");
        }
    }

    @Override
    public void findIncomeById(int id) {
        Income<T> incomeToFind = null;
        for (Income<T> income : incomeSources) {
            if (income.id == id) {
                incomeToFind = income;
                break;
            }
        }
        if (incomeToFind != null) {
            System.out.println("Income Source Details:");
            System.out.println("ID: " + incomeToFind.id);
            System.out.println("Source: " + incomeToFind.source);
            System.out.println("Amount: " + incomeToFind.amount);
            System.out.println("Date: " + incomeToFind.date.format(dateFormatter));
        } else {
            System.out.println("Income source with ID " + id + " not found.");
        }
    }

    @Override
    public void findParticularColumnById(int id, String column) {
        Income<T> incomeToFind = null;
        for (Income<T> income : incomeSources) {
            if (income.id == id) {
                incomeToFind = income;
                break;
            }
        }
        if (incomeToFind != null) {
            System.out.println("Income Source Details:");
            switch (column.toLowerCase()) {
                case "id":
                    System.out.println("ID: " + incomeToFind.id);
                    break;
                case "source":
                    System.out.println("Source: " + incomeToFind.source);
                    break;
                case "amount":
                    System.out.println("Amount: " + incomeToFind.amount);
                    break;
                case "date":
                    System.out.println("Date: " + incomeToFind.date.format(dateFormatter));
                    break;
                default:
                    System.out.println("Invalid column. Available columns: id, source, amount, date");
                    return;
            }
        } else {
            System.out.println("Income source with ID " + id + " not found.");
        }
    }
   
    
    public void incomeMenu() {
        IncomeMenu<T> incomeMenu = new IncomeMenu<>(this);
        incomeMenu.showMenu( "i");
    }

    public void expenseMenu() {
        ExpenseMenu<T> expenseMenu = new ExpenseMenu<>(this);
        expenseMenu.showMenu("e");
    }

    LocalDate parseDate(String dateInput) {
        try {
            return LocalDate.parse(dateInput, dateFormatter);
        } catch (Exception e) {
            return null;
        }

    }

    Scanner getScanner() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    int getNextId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    }
