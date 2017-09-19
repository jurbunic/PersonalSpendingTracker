package com.example.bunic.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * Created by Jurica Bunić on 15.3.2017..
 */
@Table(database = MainDatabase.class)
public class IncomeType extends BaseModel {
    @PrimaryKey(autoincrement = true)
    @Column int id;
    @Column String image;
    @Column String typeName;

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

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public static List<IncomeType> getAll(){
        return SQLite.select().from(IncomeType.class).queryList();
    }
}
