package com.example.bunic.database;

import android.support.annotation.NonNull;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.CursorResult;
import com.raizlabs.android.dbflow.sql.language.Join;
import com.raizlabs.android.dbflow.sql.language.Method;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;

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
    @ForeignKey(tableClass = ExpenseType.class)
    ExpenseType expenseType;

    public Expense() {
    }
    public Expense(int id, String name, Float cost, String currency, ExpenseType expenseType) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.currency = currency;
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


    public static List<Expense> getAll(){
        return SQLite.select().from(Expense.class).queryList();
    }

    public static List<Expense> getByExpenseType(int expenseTypeId){
        return SQLite.select().from(Expense.class).where(ExpenseType_Table.id.eq(expenseTypeId)).queryList();
    }

    public static void getTop3(){
        SQLite.select(ExpenseType_Table.typeName, Method.sum(Expense_Table.cost))
                .from(ExpenseType.class).join(Expense.class, Join.JoinType.INNER)
                .on(ExpenseType_Table.id.withTable().eq(Expense_Table.expenseType_id.withTable()))
                .groupBy(ExpenseType_Table.typeName)
                .async()
                .queryResultCallback(new QueryTransaction.QueryResultCallback<ExpenseType>() {
                    @Override
                    public void onQueryResult(QueryTransaction transaction, @NonNull CursorResult<ExpenseType> tResult) {
                        List<Top3ExpenseTypes> queryModels = tResult.toCustomListClose(Top3ExpenseTypes.class);
                    }
                });
    }

}
