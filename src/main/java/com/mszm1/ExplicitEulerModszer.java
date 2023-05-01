package com.mszm1;
import java.util.ArrayList;
import java.util.List;


public class ExplicitEulerModszer {

    public static void elso_eset(Double x0, Double y0, Double xend) {
        List<Double> t1 = num_utilities.linspace(1.0,0.5,3.0);

        List<Double> y = num_ode_solver.exact_euler(ExplicitEulerModszer::elso_fv, x0, y0, t1);

        //kiszámoljuk a valódi megoldást
        Double hh = (xend - x0)/1000;
        List<Double> points_for_exact = new ArrayList<>();
        
        for (int i = 0; i < 1001; i++) {
            points_for_exact.add(x0 + (i-1)*hh);
        }
        List<Double> exact_solutions = elso_valodi_megoldasa(points_for_exact);
        chart_data.builder().ChartTitle("Euler explicit")
            .xAxisLabel("x")
            .yAxisLabel("y")
            .frameTitle("IZÉ")
        .build()
        .addToDataset(t1, y, "Euler módszer")
        .addToDataset(points_for_exact, exact_solutions, "elméleti megoldás")
        .showYourself();
    }

    public static void masodik_eset(Double x0, Double y0, Double xend, Double[] h)
    {
        List<Double> x1 = num_utilities.linspace(x0, h[0], xend);
        List<Double> x2 = num_utilities.linspace(x0, h[1], xend);
        List<Double> y1 = num_ode_solver.exact_euler(ExplicitEulerModszer::masodik_fv, x0, y0, x1);
        List<Double> y2 = num_ode_solver.exact_euler(ExplicitEulerModszer::masodik_fv, x0, y0, x2);
        Double hh = (xend - x0)/1000;
        List<Double> points_for_exact = new ArrayList<>();
        
        for (int i = 0; i < 1001; i++) {
            points_for_exact.add(x0 + (i-1)*hh);
        }
        List<Double> exact_solutions = masodik_valodi_megoldas(points_for_exact);
        chart_data.builder().ChartTitle("Euler explicit")
            .xAxisLabel("x")
            .yAxisLabel("y")
            .frameTitle("IZÉ")
        .build()
        .addToDataset(x1, y1, "Euler módszer h:0.5")
        .addToDataset(x2, y2, "Euler módszer h:0.05")
        .addToDataset(points_for_exact, exact_solutions, "elméleti megoldás")
        .showYourself();
    }
    public static List<Double> elso_valodi_megoldasa(List<Double> x)
    {
        // y(x) = 3*e^{x-1}
        List<Double> rtn = new ArrayList<>();
        rtn.add(0, 3.0* Math.exp(0.0));
        for (int i = 1; i < x.size(); i++) {
            rtn.add(3.0* Math.exp(x.get(i)-1));
        }
        return rtn;
    }
    public static Double masodik_fv(Double[] x_y)
    {
        // y' = 2y/x + 2x^3
        return 2*x_y[0]/x_y[1] + 2*Math.pow(x_y[1], 3);
    }

    public static List<Double> masodik_valodi_megoldas(List<Double> x)
    {
        // y(x) = x^4+x^2
        List<Double> rtn = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
            rtn.add(Math.pow(x.get(i), 4) + Math.pow(x.get(i), 2));
        }
        return rtn;
    }
    public static Double elso_fv(Double[] x_t) {
        //f(x) = x
        return x_t[0];
    }
    public static void main(String[] args) throws Exception{ {
        //elso_eset(1.0, 3.0, 3.0);
        Double[] h = {0.5, 0.05};
        masodik_eset(1.0,2.0,3.0, h);
    }
}}
