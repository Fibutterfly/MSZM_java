package com.mszm1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class num_ode_solver {
    public static List<Double> exact_euler(Function<Double[],Double> funci,Double x0, Double y0, List<Double> t)
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
}
