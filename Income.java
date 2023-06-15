/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pft;

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

        public Income(T source,double amount, LocalDate date,int id) {
            this.source = source;
            this.amount=amount;
            this.date = date;
            this.id=id;
        }
    
}
