/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pft;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author ishwar
 */
public class Income<T> {

    T source;
    double amount;
    LocalDate date;
    int id;

    public Income(T source, double amount, LocalDate date, int id) {
        this.source = source;
        this.amount = amount;
        this.date = date;
        this.id = id;
    }

    public T getSource() {
        return source;
    }

    public void setSource(T source) {
        this.source = source;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
