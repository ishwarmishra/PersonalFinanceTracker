
package pft.model;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Income<T> {

    T source;
    BigDecimal amount;
    LocalDate date;
    int id;

    public Income(T source, BigDecimal amount, LocalDate date, int id) {
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
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
