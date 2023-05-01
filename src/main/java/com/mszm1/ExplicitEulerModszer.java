package com.mszm1;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class ExplicitEulerModszer {
    public static List<Double> euler(Function<Double[],Double> funci,Double x0, Double y0, List<Double> t)
    {
        Integer N = t.size();
        t.set(0, x0);
        List<Double> rtn = new ArrayList<>();
        rtn.add(0, y0);
        for (int i = 0; i < N-1; i++) {
            Double hi = t.get(i+1)- t.get(i);
            Double[] _input = {rtn.get(i),t.get(i)}; 
            Double D = funci.apply(_input);
            rtn.add(i+1,rtn.get(i)+ hi*D);
        }
        return rtn;
    }
    public static void elso_eset() {
        List<Double> t1 = new ArrayList<>();
        //kezdeti értékek
        Double x0 = 1.0;
        Double y0 = 3.0;
        Double xend = 3.0;

        //vektor(tér) generálása, ami segítségével Euler módszerrel végig iterálunk a DE-n
        Double start_num = 1.0;
        Double akt_num = start_num;
        Double different = 0.5;
        Double end_num = 3.0;
        while (akt_num<=end_num ) {
            t1.add(t1.size(), akt_num);
            akt_num = akt_num + different;
        }

        List<Double> y = euler(ExplicitEulerModszer::elso_fv, x0, y0, t1);

        //kiszámoljuk a valódi megoldást
        Double hh = (xend - x0)/1000;
        List<Double> points_for_exact = new ArrayList<>();
        List<Double> exact_solutions = new ArrayList<>();
        exact_solutions.add(elso_valodi_megoldasa(0.0));
        for (int i = 0; i < 1001; i++) {
            points_for_exact.add(x0 + (i-1)*hh);
            exact_solutions.add(elso_valodi_megoldasa(points_for_exact.get(i)-1));

        }
        chart_data.builder().ChartTitle("Euler explicit")
            .xAxisLabel("x")
            .yAxisLabel("y")
            .frameTitle("IZÉ")
        .build()
        .addToDataset(t1, y, "Euler módszer")
        .addToDataset(points_for_exact, exact_solutions, "elméleti megoldás")
        .showYourself();
        
        //Double[] xData = t1.toArray(new Double[0]);
        //Double[] yData = y.toArray(new Double[0]);
        //XYDataset dataset = createDataset(xData, yData);

        //createAndShowChart(dataset);
    }
    public static Double elso_valodi_megoldasa(Double x)
    {
        // y(x) = 3*e^{x-1}
        return 3.0* Math.exp(x);
    }
    public static Double elso_fv(Double[] x_t) {
        //f(x) = x
        return x_t[0];
    }
    public static void main(String[] args) throws Exception{ {
        elso_eset();
    }
}}
