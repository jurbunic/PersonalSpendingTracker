package com.example.bunic.database.views;

import com.example.bunic.database.Expense;
import com.example.bunic.database.Expense_Table;
import com.example.bunic.database.MainDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.QueryModel;
import com.raizlabs.android.dbflow.sql.language.Method;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseQueryModel;

import java.util.Date;
import java.util.List;

/**
 * Created by jurbunic on 20.09.17..
 */
@QueryModel(database = MainDatabase.class)
public class DailyExpenseChartData extends BaseQueryModel{
    @Column
    Date date;
    @Column
    Float cost;

    public DailyExpenseChartData() {
    }

    public DailyExpenseChartData(Date date, Float cost) {
        this.date = date;
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public static List<DailyExpenseChartData> getExpenseByWeekGrouped(Date startDate, Date endDate){
        return SQLite
                .select(Expense_Table.date.as("date"), Method.sum(Expense_Table.cost).as("cost"))
                .from(Expense.class)
                .where(Expense_Table.date.between(startDate).and(endDate))
                .groupBy(Expense_Table.date)
                .queryCustomList(DailyExpenseChartData.class);
    }

}
