package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    public SmartArray deleteDoubles() {
        Object[] obj = smartArray.toArray();
        List<Objects> new_el = new ArrayList<>();

        for (Object o: obj) {
            if (!new_el.contains(o)) {
                new_el.add((Objects) o);
            }
        }
        return new BaseArray(new_el.toArray());
    }
}
