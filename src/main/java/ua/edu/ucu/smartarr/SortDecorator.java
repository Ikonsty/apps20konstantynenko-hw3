package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private final MyComparator myComparator;
    public SortDecorator(SmartArray smartArray, MyComparator myComparator) {
        super(smartArray);
        this.myComparator = myComparator;
    }

    public SmartArray sortComp() {
        Object[] obj = smartArray.toArray();
        List<Objects> new_el = new ArrayList<>();

        for (Object o : obj) {
            new_el.add((Objects) o);
        }

        Arrays.sort(new_el.toArray(), myComparator);
        return new BaseArray(new_el.toArray());
    }
}
