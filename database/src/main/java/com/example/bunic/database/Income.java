package com.example.bunic.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Jurica Bunić on 16.3.2017..
 */
@Table(database = MainDatabase.class)
public class Income extends BaseModel implements Transaction {
    @PrimaryKey(autoincrement = true)
    @Column
    int id;
    @Column String name;
    @Column Float cost;
    @Column String currency;
    @Column Date date;
    @ForeignKey (tableClass = IncomeType.class)
    @Column IncomeType type;

    public Income() {
    }
    public Income(int id, String name, Float cost, String currency, Date date, IncomeType type) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.currency = currency;
        this.date = date;
        this.type = type;
    }

    @Override
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public Float getCost() {
        return cost;
    }
    public void setCost(Float cost) {
        this.cost = cost;
    }
    @Override
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    @Override
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public TransactionType getTransactionType() {
        return type;
    }
    public IncomeType getType() {
        return type;
    }
    public void setType(IncomeType type) {
        this.type = type;
    }

    public static List<Income> getAll(){
        return SQLite.select().from(Income.class).queryList();
    }
}
