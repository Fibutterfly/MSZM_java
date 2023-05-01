package com.mszm1;
import java.util.List;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class chart_data {
    private String ChartTitle;
    private String xAxisLabel;
    private String yAxisLabel;
    @Builder.Default
    private XYSeriesCollection dataset=new XYSeriesCollection();
    private String frameTitle;

    public chart_data addToDataset(List<Double> xdata,List<Double> ydata, String name)
    {
        XYSeries series = new XYSeries(name);
        for (int i = 0; i < xdata.size(); i++) {
            series.add(xdata.get(i), ydata.get(i));
        }
        dataset.addSeries(series);
        return this;
    }

    public void showYourself()
    {
        JFreeChart chart = ChartFactory.createXYLineChart(this.ChartTitle, this.xAxisLabel, this.yAxisLabel, this.dataset);

        // Create panel
        ChartPanel chartPanel = new ChartPanel(chart);

        // Create frame
        JFrame frame = new JFrame(this.frameTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(chartPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
