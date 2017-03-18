package com.example.bunic.personalspendingtracker.Charts;


import android.view.View;

import com.example.bunic.database.Expense;
import com.example.bunic.personalspendingtracker.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Jurica Bunić on 4.3.2017..
 */

public class ChartMainClass {

    List<Expense> expenseList;
    Calendar calendar;
    ArrayList<BarEntry> yAxisValues;
    ArrayList<String> xAxisValues;

    Date firstDayOfWeek;
    Date lastDayOfWeek;

    BarChart chart;

    public ChartMainClass(View view){
        chart = (BarChart) view.findViewById(R.id.expenses_main_barchart);
        expenseList = new ArrayList<>();
        calendar = Calendar.getInstance();

    }

    public BarChart getChartData(){
        BarData barData = new BarData(getXAxisValues(),getDataSet());
        chart.setData(barData);
        chart.invalidate();
        return chart;
    }

    private BarDataSet getDataSet(){
        yAxisValues = new ArrayList<>();

        Date dateStart = new Date();
        Date dateEnd = new Date();

        calendar.add(Calendar.DATE,-3);
        dateStart = calendar.getTime();
        calendar.add(Calendar.DATE,+7);
        dateEnd = calendar.getTime();

        expenseList = Expense.getExpenseByWeek(dateStart,dateEnd);

        for(int i=0;i<expenseList.size();i++){
            calendar.setTime(expenseList.get(i).getDate());
            int a = calendar.get(Calendar.DAY_OF_WEEK);
            yAxisValues.add(new BarEntry(expenseList.get(i).getCost(),calendar.get(Calendar.DAY_OF_WEEK)-2));
        }

        BarDataSet barDataSet = new BarDataSet(yAxisValues,"");

        return barDataSet;
    }

    private ArrayList<String> getXAxisValues(){
        xAxisValues = new ArrayList<>();
        xAxisValues.add("Monday");
        xAxisValues.add("Tuesday");
        xAxisValues.add("Wednesday");
        xAxisValues.add("Thursday");
        xAxisValues.add("Friday");
        xAxisValues.add("Saturday");
        xAxisValues.add("Sunday");
        return xAxisValues;
    }

}
