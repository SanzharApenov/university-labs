import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sorting<Integer> {

    private void slice(List<Integer> nums, int start, int end) {
        if (start >= end) return;

        int middle = start + (end - start) / 2;
        slice(nums, start, middle);
        slice(nums, middle + 1, end);
        merge(nums, start, middle, end);
    }

    private void merge(List<Integer> nums, int start, int middle, int end) {
        List<Integer> temp = new ArrayList<>();
        int i = start, j = middle + 1;

        while (i <= middle && j <= end) {
            if (nums.get(i) <= nums.get(j))
                temp.add(nums.get(i++));
            else
                temp.add(nums.get(j++));
        }

        while (i <= middle) temp.add(nums.get(i++));
        while (j <= end) temp.add(nums.get(j++));

        for (int k = 0; k < temp.size(); k++)
            nums.set(start + k, temp.get(k));
    }

    @Override
    public void sort(List<Integer> nums) {
        slice(nums, 0, nums.size() - 1);
    }
}
