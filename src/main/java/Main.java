import ua.edu.ucu.SmartArrayApp;
import ua.edu.ucu.Student;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};

        Integer[] res =
                SmartArrayApp.filterPositiveIntegersSortAndMultiplyBy2
                        (integers);
        System.out.println(Arrays.toString(res));



        Student[] students = {
                new Student("Ivar", "Grimstad", 3.9, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Antons", "Kranga", 4.0, 2),
                new Student("Burr", "Sutter", 4.2, 2),
                new Student("Philipp", "Krenn", 4.3, 3),
                new Student("Tomasz", "Borek", 4.1, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Burr", "Sutter", 4.2, 2)};
        String[] studentNames =
                SmartArrayApp.
                        findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname
                        (students);
        System.out.println(Arrays.toString(studentNames));
    }
}
