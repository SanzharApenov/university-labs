import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++)
            nums.add(scanner.nextInt());

        MergeSort sorting = new MergeSort();
        sorting.sort(nums);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) result.append(' ');
            result.append(nums.get(i));
        }
        System.out.println(result);
    }
}
