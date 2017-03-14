package com.example.bunic.database.static_data;

import com.example.bunic.database.ExpenseType;

/**
 * Created by Jurica Bunić on 8.3.2017..
 */

public class ExpenseTypesData {
    public static void writeExpenseTypesToDb(){
        ExpenseType transport = new ExpenseType(1,"list_icon_expense_transport", "Transport");
        transport.save();

        ExpenseType food = new ExpenseType(2,"list_icon_expense_food","Food");
        food.save();

        ExpenseType drink = new ExpenseType(3, "list_icon_expense_drink", "Drink");
        drink.save();

        ExpenseType rent = new ExpenseType(4, "list_icon_expense_rent", "Rent");
        rent.save();

        ExpenseType cultural = new ExpenseType(5,"list_icon_expense_culture", "Cultural");
        cultural.save();

        ExpenseType hobbies = new ExpenseType(6, "list_icon_expense_hobbies", "Hobbies");
        hobbies.save();
    }
}
