public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++)
            students.add(new Student(scanner.next(), scanner.nextInt()));

        StudentSort sorting = new StudentSort();
        sorting.sort(students);

        StringBuilder result = new StringBuilder();
        for (Student student : students)
            result.append(student.getName()).append(' ')
                  .append(student.getAge()).append('\n');

        System.out.print(result);
    }
}
