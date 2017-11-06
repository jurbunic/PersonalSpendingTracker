package com.example.bunic.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.ArrayList;
import java.util.List;

import static com.raizlabs.android.dbflow.sql.language.SQLite.select;

/**
 * Created by Jurica Bunić on 15.3.2017..
 */
@Table(database = MainDatabase.class)
public class IncomeType extends BaseModel implements TransactionType{
    @PrimaryKey(autoincrement = true)
    @Column int id;
    @Column String image;
    @Column String typeName;

    List<Income> incomeList = new ArrayList<>();
    public IncomeType() {
    }

    public IncomeType(String image, String typeName) {
        this.image = image;
        this.typeName = typeName;
    }

    public IncomeType(int id, String image, String typeName) {
        this.id = id;
        this.image = image;
        this.typeName = typeName;
    }

    @Override
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    @Override
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    @Override
    public List<? extends Transaction> getTransactionList() {
        return getIncomeList();
    }

    public static List<IncomeType> getAll(){
        return SQLite.select().from(IncomeType.class).queryList();
    }
    public List<Income> getIncomeList(){
        if(incomeList == null ||incomeList.isEmpty()){
            incomeList = SQLite.select().from(Income.class)
                    .where(Income_Table.type_id.eq(id))
                    .queryList();
        }
        return incomeList;
    }

    public static IncomeType incomeType(String incomeName) {
        return select().from(IncomeType.class).where(IncomeType_Table.typeName.eq(incomeName)).querySingle();
    }
}
