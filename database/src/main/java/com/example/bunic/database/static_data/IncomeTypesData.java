package com.example.bunic.database.static_data;

import com.example.bunic.database.IncomeType;

/**
 * Created by Jurica Bunić on 8.3.2017..
 */

public class IncomeTypesData {
    public static void writeExpenseTypesToDb(){
        IncomeType job = new IncomeType(1,"list_icon_expense_transport", "Job");
        job.save();

        IncomeType allowance = new IncomeType(2,"list_icon_expense_food","Allowance");
        allowance.save();

        IncomeType gift = new IncomeType(3, "list_icon_expense_drink", "Gift");
        gift.save();

    }
}
