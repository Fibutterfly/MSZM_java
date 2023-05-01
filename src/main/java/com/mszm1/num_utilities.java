package com.mszm1;
import java.util.ArrayList;
import java.util.List;

public class num_utilities {
    public static List<Double> linspace(Double start_num,Double different,Double end_num)
    {
        //vektor(tér) generálása, ami segítségével Euler módszerrel végig iterálunk a DE-n
        List<Double> t1 = new ArrayList<>();
        Double akt_num = start_num;
        while (akt_num<=end_num ) {
            t1.add(t1.size(), akt_num);
            akt_num = akt_num + different;
        }
        return t1;
    }
}
