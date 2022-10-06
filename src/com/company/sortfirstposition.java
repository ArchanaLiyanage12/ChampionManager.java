package com.company;

import java.util.Comparator;

public class sortfirstposition implements Comparator<Formula1Driver> {


      @Override
    public int compare(Formula1Driver o1, Formula1Driver o2) {      // compare positions
        return o2.getNumoffirstposition() - o1.getNumoffirstposition();
    }
}
