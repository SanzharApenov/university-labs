import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int age = scanner.nextInt();
            students.add(new Student(name, age));
        }

        StudentSort sorting = new StudentSort();
        sorting.sort(students);

        for (int i = 0; i < n; i++) {
            Student student = students.get(i);
            System.out.println(student.getName() + " " + student.getAge());
        }
    }
}
