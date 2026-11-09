import java.util.ArrayList;
import java.util.List;

public class StudentSort implements Sorting<Student> {

    private void sift(List<Student> students, int size, int root) {
        while (2 * root + 1 < size) {
            int child = 2 * root + 1;

            if (child + 1 < size &&
                    students.get(child).compareTo(students.get(child + 1)) < 0)
                child++;

            if (students.get(root).compareTo(students.get(child)) >= 0)
                return;

            Student temp = students.get(root);
            students.set(root, students.get(child));
            students.set(child, temp);
            root = child;
        }
    }

    private void heapSort(List<Student> students) {
        int n = students.size();

        for (int i = n / 2 - 1; i >= 0; i--)
            sift(students, n, i);

        for (int i = n - 1; i > 0; i--) {
            Student temp = students.get(0);
            students.set(0, students.get(i));
            students.set(i, temp);
            sift(students, i, 0);
        }
    }

    private void mergeSort(List<Student> students, int start, int end) {
        if (start >= end) return;

        int middle = start + (end - start) / 2;
        mergeSort(students, start, middle);
        mergeSort(students, middle + 1, end);

        List<Student> temp = new ArrayList<>();
        int i = start, j = middle + 1;

        while (i <= middle && j <= end) {
            if (students.get(i).getName()
                    .compareTo(students.get(j).getName()) <= 0)
                temp.add(students.get(i++));
            else
                temp.add(students.get(j++));
        }

        while (i <= middle) temp.add(students.get(i++));
        while (j <= end) temp.add(students.get(j++));

        for (int k = 0; k < temp.size(); k++)
            students.set(start + k, temp.get(k));
    }

    @Override
    public void sort(List<Student> students) {
        heapSort(students);
        mergeSort(students, 0, students.size() - 1);
    }
}
