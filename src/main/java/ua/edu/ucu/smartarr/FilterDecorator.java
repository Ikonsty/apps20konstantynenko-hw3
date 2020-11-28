package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate myPredicate;
    public FilterDecorator(SmartArray smartArray, MyPredicate myPredicate) {
        super(smartArray);
        this.myPredicate = myPredicate;
    }

    public SmartArray filter() {
        Object[] obj = smartArray.toArray();
        List<Objects> new_el = new ArrayList<>();

        for (Object o: obj) {
            if (myPredicate.test(o)) {
                new_el.add((Objects) o);
            }
        }
        return new BaseArray(new_el.toArray());
    }
}
