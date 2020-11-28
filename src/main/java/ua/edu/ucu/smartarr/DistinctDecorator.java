package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.List;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    public SmartArray deleteDoubles() {
        Object[] obj = smartArray.toArray();
        List<Object> newEl = new ArrayList<>();

        boolean dupl = false;
        for (Object o: obj) {
            for (Object was: newEl) {
                if (o.toString().equals(was.toString())) {
                    dupl = true;
                    break;
                }
            }
            if (!dupl) {
                newEl.add(o);
            }
        }
        return new BaseArray(newEl.toArray());
    }
}
