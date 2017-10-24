package com.example.bunic.database.views;

import com.example.bunic.database.Expense;
import com.example.bunic.database.Expense_Table;
import com.example.bunic.database.Income;
import com.example.bunic.database.Income_Table;
import com.example.bunic.database.MainDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.QueryModel;
import com.raizlabs.android.dbflow.sql.language.Method;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseQueryModel;

import java.util.Date;

/**
 * Created by jurbunic on 04.10.17..
 */
@QueryModel(database = MainDatabase.class)
public class WeeklyBalance extends BaseQueryModel {
    @Column
    String balance;


    public static String getWeeklyBalance(Date startDate, Date endDate){
        Income weeklyIncome = SQLite
                .select(Method.sum(Income_Table.cost).as("cost"))
                .from(Income.class)
                .where(Income_Table.date.between(startDate).and(endDate))
                .querySingle();
        Expense weeklyExpense = SQLite
                .select(Method.sum(Expense_Table.cost).as("cost"))
                .from(Expense.class)
                .where(Expense_Table.date.between(startDate).and(endDate))
                .querySingle();
        Double results = 0d;
        try{
            if (weeklyIncome != null && weeklyIncome.getCost() != null) {
                results += weeklyIncome.getCost();
            }
            if (weeklyExpense != null && weeklyExpense.getCost() != null){
                results -= weeklyExpense.getCost();
            }
            return String.valueOf(results);
        }catch (Exception e){
            return "0";
        }
    }
}
