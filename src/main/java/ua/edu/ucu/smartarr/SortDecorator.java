package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.*;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private final MyComparator myComparator;
    public SortDecorator(SmartArray smartArray, MyComparator myComparator) {
        super(smartArray);
        this.myComparator = myComparator;
    }

    public SmartArray sortComp() {
        Object[] obj = smartArray.toArray();
        Arrays.sort(obj, myComparator);
        return new BaseArray(obj);
    }
}
