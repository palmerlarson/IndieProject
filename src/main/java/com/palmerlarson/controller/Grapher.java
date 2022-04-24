package com.palmerlarson.controller;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.io.File;
import java.io.IOException;

/**
 * Class used as practice - will be used as main graph creation class
 */
public class Grapher {
    public static void main(String[] args) throws IOException {
        String P1 = "Player 1";
        String P2 = "Player 2";
        String Attk = "Attack";
        String Def = "Defense";
        String Speed = "Speed";
        String Stealth = "Stealth";

        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

        // Player 1
        dataset.addValue(10, P1, Attk);
        dataset.addValue(7, P1, Def);
        dataset.addValue(6, P1, Speed);
        dataset.addValue(6, P1, Stealth);

        // Player 2
        dataset.addValue(7, P2, Attk);
        dataset.addValue(9, P2, Def);
        dataset.addValue(8, P2, Speed);
        dataset.addValue(8, P2, Stealth);

        JFreeChart barChart = ChartFactory.createBarChart("JFreeChart BarChart", "Players", "Points",
                dataset, PlotOrientation.VERTICAL, true, true, false);

        ChartUtils.saveChartAsPNG(new File("/Users/palmerlarson/IdeaProjects/IndieProject/GraphCharts/chart.png"), barChart, 650, 400);
    }
}
