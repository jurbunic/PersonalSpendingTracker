package com.example.bunic.database.static_data;

import com.example.bunic.database.IncomeType;

/**
 * Created by Jurica Bunić on 8.3.2017..
 */

public class IncomeTypesData {
    public static void writeIncomeTypesToDb(){
        IncomeType job = new IncomeType("list_icon_income_job", "Job");
        job.save();

        IncomeType allowance = new IncomeType("list_icon_income_allowance","Allowance");
        allowance.save();

        IncomeType gift = new IncomeType("list_icon_income_gift", "Gift");
        gift.save();

    }
}
