import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RadixSort implements Sorting<BigInteger> {

    private int digit(BigInteger number, BigInteger place) {
        return number.divide(place).mod(BigInteger.TEN).intValue();
    }

    public void sort(List<BigInteger> nums) {
        List<BigInteger> temp = new ArrayList<>(nums);
        BigInteger place = BigInteger.ONE;

        for (int step = 0; step < 20; step++) {
            int[] count = new int[10];

            for (int i = 0; i < nums.size(); i++) {
                int d = digit(nums.get(i), place);
                count[d]++;
            }

            for (int i = 1; i < 10; i++) {
                count[i] = count[i] + count[i - 1];
            }

            for (int i = nums.size() - 1; i >= 0; i--) {
                int d = digit(nums.get(i), place);
                count[d]--;
                temp.set(count[d], nums.get(i));
            }

            for (int i = 0; i < nums.size(); i++) {
                nums.set(i, temp.get(i));
            }

            place = place.multiply(BigInteger.TEN);
        }
    }
}
