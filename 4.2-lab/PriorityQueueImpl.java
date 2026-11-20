public class PriorityQueueImpl implements PriorityQueue<Integer> {
    private int[] values = new int[100001];
    private int[] numbers = new int[100001];
    private int[] positions = new int[100001];

    private int size;
    private int added;
    private int removedNumber;

    private void swap(int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;

        temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;

        positions[numbers[i]] = i;
        positions[numbers[j]] = j;
    }

    private void up(int i) {
        while (i > 1 && values[i] > values[i / 2]) {
            swap(i, i / 2);
            i = i / 2;
        }
    }

    private void down(int i) {
        while (2 * i <= size) {
            int child = 2 * i;

            if (child + 1 <= size &&
                values[child + 1] > values[child]) {
                child++;
            }

            if (values[i] >= values[child]) {
                return;
            }

            swap(i, child);
            i = child;
        }
    }

    public void enqueue(Integer value) {
        added++;
        size++;

        values[size] = value;
        numbers[size] = added;
        positions[added] = size;

        up(size);
    }

    public Integer dequeueMax() {
        if (size == 0) {
            return null;
        }

        int result = values[1];
        removedNumber = numbers[1];

        swap(1, size);
        positions[removedNumber] = 0;
        size--;

        if (size > 0) {
            down(1);
        }

        return result;
    }

    public void increment(long operation, Integer addition) {
        if (operation < 1 || operation > added) {
            return;
        }

        int number = (int) operation;
        int i = positions[number];

        if (i == 0) {
            return;
        }

        values[i] = values[i] + addition;

        if (addition >= 0) {
            up(i);
        } else {
            down(i);
        }
    }

    public int getRemovedNumber() {
        return removedNumber;
    }
}
