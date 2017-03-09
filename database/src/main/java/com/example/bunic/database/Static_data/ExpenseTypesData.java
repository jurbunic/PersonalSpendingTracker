package com.example.bunic.database.Static_data;

import com.example.bunic.database.ExpenseType;

import java.util.List;

/**
 * Created by Jurica Bunić on 8.3.2017..
 */

public class ExpenseTypesData {
    public static void writeExpenseTypesToDb(List<ExpenseType> types){
        ExpenseType transport = new ExpenseType(0,"list_icon_expense_transport","Transport");
        types.add(transport);
        transport.save();

        ExpenseType food = new ExpenseType(1,"list_icon_expense_food","Food");
        types.add(food);
        food.save();

        ExpenseType drink = new ExpenseType(2, "list_icon_expense_drink", "Drink");
        types.add(drink);
        drink.save();

        ExpenseType rent = new ExpenseType(3, "list_icon_expense_rent", "Rent");
        types.add(rent);
        rent.save();

        ExpenseType cultural = new ExpenseType(4,"list_icon_expense_culture", "Cultural");
        types.add(cultural);
        cultural.save();

        ExpenseType hobbies = new ExpenseType(5, "list_icon_expense_hobbies", "Hobbies");
        types.add(hobbies);
        hobbies.save();

    }
}
