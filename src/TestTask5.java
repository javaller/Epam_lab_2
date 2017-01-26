import java.util.*;

/**
 * Created by Home on 22.01.2017.
 */

class Subject<T extends Number> {
    T mark;
    String name;

    public Subject(T mark, String name) {
        this.mark = mark;
        this.name = name;
    }

}

class Student {
    List<Subject> subjects;
    String name;

    public Student(String name, List<Subject> subjects) {
        this.subjects = subjects;
        this.name = name;
    }
}

public class TestTask5 {
    public static void main(String[] args) {
        Subject<Double> biology = new Subject<>(5.0, "fitness");
        Subject<Integer> english = new Subject<>(4, "englis");
        Subject<Integer> russian = new Subject<>(3, "russian");

        List<Subject> subjects = Arrays.asList(biology, english, russian);


        List<Subject> subjects1 = Arrays
                .asList(new Subject<>(5.0, "fitness")
                        , new Subject<>(4, "programming")
                        , new Subject<>(2, "russian"));


        Student st1 = new Student("Ivan", subjects);
        Student st2 = new Student("Katja", subjects1);
        Student st3 = new Student("Masha", Arrays.asList(new Subject<>(5.0, "fitness")
                , new Subject<>(4, "programming")));


        List<Student> allStudents = Arrays.asList(st1, st2, st3);


        // формирование группы студентов русского языка
        List<Student> russianStudents = new ArrayList<>();

        FIRST_LOOP:
        for (Student st : allStudents) {
            for (Subject sbj : st.subjects) {
                if (sbj.name == "russian") {
                    System.out.println(st.name + " true");
                    russianStudents.add(st);
                    continue FIRST_LOOP;
                }
            }
            System.out.println(st.name + " false");
        }

        // Вхождение студента в группу
        for (Student st : russianStudents) {
            if (st.equals(st2)) {
                System.out.println("Student does study this subject.");
                break;
            }
        }
        System.out.println("Student does not study this subject.");

        //Сравнение оценок у студента
        Comparator<Subject> byMark = new Comparator<Subject>() {
            @Override
            public int compare(Subject s1, Subject s2) {
                double d1;
                double d2;
                if (s1.mark instanceof Integer) {
                    d1 = (double) (Integer) s1.mark;
                } else {
                    d1 = (double) s1.mark;
                }
                if (s2.mark instanceof Integer) {
                    d2 = (double) (Integer) s2.mark;
                } else {
                    d2 = (double) s2.mark;
                }

                if (d1 < d2) return -1;
                if (d1 > d2) return 1;
                return 0;
            }
        };

        Collections.sort(st1.subjects, byMark);

        for (Subject sbj : st1.subjects) {
            System.out.println(sbj.name + " " + sbj.mark);
        }

    }
}