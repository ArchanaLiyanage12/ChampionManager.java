package com.company;
import java.util.Comparator;

public class sortpoint implements Comparator<Formula1Driver> {
    @Override
    public int compare(Formula1Driver o1, Formula1Driver o2) {  // compare points
        return o2.getPoints() - o1.getPoints();
    }
}
