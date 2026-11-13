import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<BigInteger> nums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nums.add(scanner.nextBigInteger());
        }

        RadixSort sorting = new RadixSort();
        sorting.sort(nums);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            result.append(nums.get(i)).append('\n');
        }

        System.out.print(result);
    }
}
