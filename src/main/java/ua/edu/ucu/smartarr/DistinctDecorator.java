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
        List<Object> new_el = new ArrayList<>();

        boolean dupl = false;
        for (Object o: obj) {
            for (Object was: new_el) {
                if (o.toString().equals(was.toString())) {
                    dupl = true;
                    break;
                }
            }
            if (!dupl) {
                new_el.add(o);
            }
        }
        return new BaseArray(new_el.toArray());
    }
}
