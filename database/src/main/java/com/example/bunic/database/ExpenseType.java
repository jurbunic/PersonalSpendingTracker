package com.example.bunic.database;



import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;
import java.util.List;
import static com.raizlabs.android.dbflow.sql.language.SQLite.select;

/**
 * Created by Jurica Bunić on 8.3.2017..
 */
@Table(database = MainDatabase.class)
public class ExpenseType extends BaseModel{
    @PrimaryKey(autoincrement = true)
    @Column int id;
    @Column String image;
    @Column String typeName;

    List<Expense> expenseList;

    public ExpenseType() {
    }

    public ExpenseType(String image, String typeName) {
        this.image = image;
        this.typeName = typeName;
    }

    public ExpenseType(ExpenseType expenseType){
        this.id = expenseType.getId();
        this.image = expenseType.getImage();
        this.typeName = expenseType.getTypeName();
        this.expenseList = expenseType.getExpenseList();
    }

    public ExpenseType(int id, String image, String typeName) {
        this.id = id;
        this.image = image;
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public static List<ExpenseType> getAll(){
        return select().from(ExpenseType.class).where().queryList();
    }

    public List<Expense> getExpenseList(){
        if(expenseList == null ||expenseList.isEmpty()){
            expenseList = SQLite.select().from(Expense.class)
                    .where(Expense_Table.expenseType_id.eq(id))
                    .queryList();
        }
        return expenseList;
    }

    public static ExpenseType expenseType(String expenseName) {
        return select().from(ExpenseType.class).where(ExpenseType_Table.typeName.eq(expenseName)).querySingle();
    }



}
