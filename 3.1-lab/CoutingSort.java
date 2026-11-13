import java.util.List;

public class CountingSort implements Sorting<Integer> {
    public void sort(List<Integer> nums) {
        int[] count = new int[128];

        for (int i = 0; i < nums.size(); i++) {
            int number = nums.get(i);
            count[number]++;
        }

        int index = 0;

        for (int number = 0; number < 128; number++) {
            for (int j = 0; j < count[number]; j++) {
                nums.set(index, number);
                index++;
            }
        }
    }
}
