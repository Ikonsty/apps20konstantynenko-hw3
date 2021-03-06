package ua.edu.ucu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.SortDecorator;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.MapDecorator;
import ua.edu.ucu.smartarr.DistinctDecorator;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object objOne, Object objTwo) {
                return ((Integer) objOne) - ((Integer) objTwo);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr).filter(); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp).sortComp(); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func).map(); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname
            (Student[] students) {

        // Hint: to convert Object[] to String[] - use the following code
        //Object[] result = studentSmartArray.toArray();
        //return Arrays.copyOf(result, result.length, String[].class);
        MyPredicate predicateOne = new MyPredicate() {
            @Override
            public boolean test(Object st) {
                return ((Student) st).getYear() == 2;
            }
        };

        MyPredicate predicateTwo = new MyPredicate() {
            @Override
            public boolean test(Object st) {
                return ((Student) st).getGPA() >= 4;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object objOne, Object objTwo) {
                return ((Student) objOne).getSurname().compareToIgnoreCase
                        (((Student) objTwo).getSurname());
            }
        };


        SmartArray sa = new BaseArray(students);

        sa = new DistinctDecorator(sa).deleteDoubles();
        sa = new FilterDecorator(sa, predicateOne).filter();
        sa = new FilterDecorator(sa, predicateTwo).filter();
        sa = new SortDecorator(sa, cmp).sortComp();

        Object[] st = sa.toArray();
        List<String> result = new ArrayList<>();
        for (Object s: st) {
            result.add(((Student) s).getSurname() + " " + ((Student) s).
                    getName());
        }
        Object[] res = result.toArray();
        return Arrays.copyOf(res, res.length, String[].class);
    }
}
