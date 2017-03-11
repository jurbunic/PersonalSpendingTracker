package com.example.bunic.database;



import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
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

    public ExpenseType() {
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

    public static ExpenseType expenseType(String expenseName) {
        return select().from(ExpenseType.class).where(ExpenseType_Table.typeName.eq(expenseName)).querySingle();
    }

}
