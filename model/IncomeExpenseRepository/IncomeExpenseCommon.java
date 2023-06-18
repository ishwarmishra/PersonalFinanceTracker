/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pft.model.IncomeExpenseRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ishwar
 */
public class IncomeExpenseCommon {
    public LocalDate parseDate(String dateInput,DateTimeFormatter dateFormatter) {
        try {
            return LocalDate.parse(dateInput, dateFormatter);
        } catch (Exception e) {
            
            return null;
        }

    }
    
}
