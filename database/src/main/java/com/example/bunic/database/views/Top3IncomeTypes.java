package com.example.bunic.database.views;

import com.example.bunic.database.Income;
import com.example.bunic.database.IncomeType;
import com.example.bunic.database.IncomeType_Table;
import com.example.bunic.database.Income_Table;
import com.example.bunic.database.MainDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.QueryModel;
import com.raizlabs.android.dbflow.sql.language.Join;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseQueryModel;

import java.util.List;

import static com.raizlabs.android.dbflow.sql.language.Method.sum;

/**
 * Created by jurbunic on 20.09.17..
 */
@QueryModel(database = MainDatabase.class)
public class Top3IncomeTypes extends BaseQueryModel {
    @Column
    String incomeTypeName;
    @Column
    Float incomeTypeCost;
    @Column
    String incomeTypeIcon;

    public Top3IncomeTypes() {
    }

    public Top3IncomeTypes(String incomeTypeName, Float incomeTypeCost, String incomeTypeIcon) {
        this.incomeTypeName = incomeTypeName;
        this.incomeTypeCost = incomeTypeCost;
        this.incomeTypeIcon = incomeTypeIcon;
    }

    public String getIncomeTypeName() {
        return incomeTypeName;
    }

    public void setIncomeTypeName(String incomeTypeName) {
        this.incomeTypeName = incomeTypeName;
    }

    public Float getIncomeTypeCost() {
        return incomeTypeCost;
    }

    public void setIncomeTypeCost(Float incomeTypeCost) {
        this.incomeTypeCost = incomeTypeCost;
    }

    public String getIncomeTypeIcon() {
        return incomeTypeIcon;
    }

    public void setIncomeTypeIcon(String incomeTypeIcon) {
        this.incomeTypeIcon = incomeTypeIcon;
    }

    public static List<Top3IncomeTypes> getTop3Types(){
        return SQLite
                .select(IncomeType_Table.typeName.as("incomeTypeName")
                        ,IncomeType_Table.image.as("incomeTypeIcon")
                        ,sum(Income_Table.cost).as("incomeTypeCost"))
                .from(IncomeType.class).join(Income.class, Join.JoinType.INNER)
                .on(IncomeType_Table.id.withTable().eq(Income_Table.type_id.withTable()))
                .groupBy(IncomeType_Table.typeName)
                .orderBy(NameAlias.builder("incomeTypeCost").build(),false)
                .limit(3)
                .queryCustomList(Top3IncomeTypes.class);
    }
}
