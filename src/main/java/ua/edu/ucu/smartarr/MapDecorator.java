package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction myFunction;
    public MapDecorator(SmartArray smartArray, MyFunction myFunction) {
        super(smartArray);
        this.myFunction = myFunction;
    }

    public SmartArray map() {
        Object[] obj = smartArray.toArray();
        List<Objects> new_el = new ArrayList<>();

        for (Object o: obj) {
            new_el.add((Objects) myFunction.apply(o));
        }
        return new BaseArray(new_el.toArray());
    }
}
