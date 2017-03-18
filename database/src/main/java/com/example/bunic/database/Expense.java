package com.example.bunic.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.Condition;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Jurica Bunić on 8.3.2017..
 */
@Table(database = MainDatabase.class)
public class Expense extends BaseModel {
    @PrimaryKey(autoincrement = true)
    @Column int id;
    @Column String name;
    @Column Float cost;
    @Column String currency;
    @Column
    Date date;

    @Column
    @ForeignKey(tableClass = ExpenseType.class)
    ExpenseType expenseType;

    public Expense() {
    }

    public Expense(int id, String name, Float cost, String currency, Date date, ExpenseType expenseType) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.currency = currency;
        this.date = date;
        this.expenseType = expenseType;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Float getCost() {
        return cost;
    }
    public void setCost(Float cost) {
        this.cost = cost;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public ExpenseType getExpenseType() {
        return expenseType;
    }
    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public static List<Expense> getAll(){
        return SQLite.select().from(Expense.class).queryList();
    }

    public static List<Expense> getByExpenseType(int expenseTypeId){
        return SQLite.select().from(Expense.class).where(ExpenseType_Table.id.eq(expenseTypeId)).queryList();
    }

    public static Expense getExpenseById(int id){
        return SQLite.select().from(Expense.class).where(Expense_Table.id.eq(id)).querySingle();
    }

    public static List<Expense> getExpenseByWeek(Date startDate, Date endDate){
        return SQLite
                .select()
                .from(Expense.class)
                .where(Expense_Table.date.between(startDate).and(endDate))
                .queryList();
    }

}
