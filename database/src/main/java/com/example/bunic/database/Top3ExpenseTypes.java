package com.example.bunic.database;




import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.QueryModel;
import com.raizlabs.android.dbflow.sql.language.Join;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseQueryModel;
import java.util.List;
import static com.raizlabs.android.dbflow.sql.language.Method.sum;


/**
 * Created by Jurica Bunić on 9.3.2017..
 */
@QueryModel(database = MainDatabase.class)
public class Top3ExpenseTypes extends BaseQueryModel {

    @Column
    String expenseTypeName;
    @Column
    Float expenseTypeCost;
    @Column
    String expenseTypeIcon;

    public Top3ExpenseTypes() {
    }

    public Top3ExpenseTypes(String expenseTypeName, Float expenseTypeCost, String expenseTypeIcon) {
        this.expenseTypeName = expenseTypeName;
        this.expenseTypeCost = expenseTypeCost;
        this.expenseTypeIcon = expenseTypeIcon;
    }

    public String getExpenseTypeName() {
        return expenseTypeName;
    }
    public void setExpenseTypeName(String expenseTypeName) {
        this.expenseTypeName = expenseTypeName;
    }
    public Float getExpenseTypeCost() {
        return expenseTypeCost;
    }
    public void setExpenseTypeCost(Float expenseTypeCost) {
        this.expenseTypeCost = expenseTypeCost;
    }
    public String getExpenseTypeIcon() {
        return expenseTypeIcon;
    }
    public void setExpenseTypeIcon(String expenseTypeIcon) {
        this.expenseTypeIcon = expenseTypeIcon;
    }

    public static List<Top3ExpenseTypes> getTop3Types(){
        return SQLite
                .select(ExpenseType_Table.typeName.as("expenseTypeName")
                        ,ExpenseType_Table.image.as("expenseTypeIcon")
                        ,sum(Expense_Table.cost).as("expenseTypeCost"))
                .from(ExpenseType.class).join(Expense.class, Join.JoinType.INNER)
                .on(ExpenseType_Table.id.withTable().eq(Expense_Table.expenseType_id.withTable()))
                .groupBy(ExpenseType_Table.typeName)
                .orderBy(NameAlias.builder("expenseTypeCost").build(),false)
                .limit(3)
                .queryCustomList(Top3ExpenseTypes.class);
    }

}
