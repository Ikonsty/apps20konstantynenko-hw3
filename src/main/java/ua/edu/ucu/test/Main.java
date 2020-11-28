package ua.edu.ucu.test;

import ua.edu.ucu.functions.*;
import ua.edu.ucu.smartarr.*;

public class Main {
    public static void main(String[] args) {
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        Integer[] integers = {-1, 2, 0, 1, -5, 3};
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr).filter(); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp).sortComp(); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func).map(); // Result: [2, 4, 6]
    }
}
