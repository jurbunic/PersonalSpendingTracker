package com.example.bunic.personalspendingtracker.Charts;


import android.view.View;

import com.example.bunic.personalspendingtracker.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import java.util.ArrayList;

/**
 * Created by Jurica Bunić on 4.3.2017..
 */

public class ChartMainClass {


    ArrayList<BarEntry> yAxisValues;
    ArrayList<String> xAxisValues;

    BarChart chart;

    public ChartMainClass(View view){
        chart = (BarChart) view.findViewById(R.id.expenses_main_barchart);
    }

    public BarChart getChartData(){
        BarData barData = new BarData(getXAxisValues(),getDataSet());
        chart.setData(barData);
        chart.invalidate();
        return chart;
    }

    private BarDataSet getDataSet(){

        yAxisValues = new ArrayList<>();
        yAxisValues.add(new BarEntry(20f,0));
        yAxisValues.add(new BarEntry(22f,1));
        yAxisValues.add(new BarEntry(24f,2));
        yAxisValues.add(new BarEntry(26f,3));
        yAxisValues.add(new BarEntry(28f,4));
        yAxisValues.add(new BarEntry(30f,5));
        yAxisValues.add(new BarEntry(32f,6));


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
