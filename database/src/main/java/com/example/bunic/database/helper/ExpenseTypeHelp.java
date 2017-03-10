package com.example.bunic.database.helper;


import com.example.bunic.database.MainDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.QueryModel;
import com.raizlabs.android.dbflow.structure.BaseQueryModel;




/**
 * Created by Jurica Bunić on 9.3.2017..
 */
@QueryModel(database = MainDatabase.class)
public class ExpenseTypeHelp extends BaseQueryModel {
    @Column
    String expenseTypeName;

    @Column
    float expenseTypeTotalCost;

    public ExpenseTypeHelp() {
    }

    public ExpenseTypeHelp(String expenseTypeName, float expenseTypeTotalCost) {
        this.expenseTypeName = expenseTypeName;
        this.expenseTypeTotalCost = expenseTypeTotalCost;
    }

    public String getExpenseTypeName() {
        return expenseTypeName;
    }
    public void setExpenseTypeName(String expenseTypeName) {
        this.expenseTypeName = expenseTypeName;
    }
    public float getExpenseTypeTotalCost() {
        return expenseTypeTotalCost;
    }
    public void setExpenseTypeTotalCost(float expenseTypeTotalCost) {
        this.expenseTypeTotalCost = expenseTypeTotalCost;
    }



}
