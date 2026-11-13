import java.util.ArrayList;
import java.util.List;

public class StudentSort implements Sorting<Student> {

    private void swap(List<Student> students, int i, int j) {
        Student temp = students.get(i);
        students.set(i, students.get(j));
        students.set(j, temp);
    }

    private void sift(List<Student> students, int size, int root) {
        while (2 * root + 1 < size) {
            int child = 2 * root + 1;

            if (child + 1 < size) {
                if (students.get(child).getAge() <
                    students.get(child + 1).getAge()) {
                    child++;
                }
            }

            if (students.get(root).getAge() >= students.get(child).getAge()) {
                return;
            }

            swap(students, root, child);
            root = child;
        }
    }

    private void heapSort(List<Student> students) {
        int n = students.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            sift(students, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(students, 0, i);
            sift(students, i, 0);
        }
    }

    private void mergeSort(List<Student> students, int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = start + (end - start) / 2;
        mergeSort(students, start, middle);
        mergeSort(students, middle + 1, end);

        List<Student> temp = new ArrayList<>();
        int i = start;
        int j = middle + 1;

        while (i <= middle && j <= end) {
            String leftName = students.get(i).getName();
            String rightName = students.get(j).getName();

            if (leftName.compareTo(rightName) <= 0) {
                temp.add(students.get(i));
                i++;
            } else {
                temp.add(students.get(j));
                j++;
            }
        }

        while (i <= middle) {
            temp.add(students.get(i));
            i++;
        }

        while (j <= end) {
            temp.add(students.get(j));
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            students.set(start + k, temp.get(k));
        }
    }

    public void sort(List<Student> students) {
        heapSort(students);
        mergeSort(students, 0, students.size() - 1);
    }
}
