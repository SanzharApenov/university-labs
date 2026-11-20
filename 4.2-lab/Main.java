import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueueImpl queue = new PriorityQueueImpl();

        while (scanner.hasNext()) {
            String command = scanner.next();

            if (command.equals("enqueue")) {
                queue.enqueue(scanner.nextInt());

            } else if (command.equals("dequeue-max")) {
                Integer value = queue.dequeueMax();

                if (value == null) {
                    System.out.println("*");
                } else {
                    System.out.println(
                        queue.getRemovedNumber() + " " + value
                    );
                }

            } else if (command.equals("inc")) {
                long number = scanner.nextLong();
                int addition = scanner.nextInt();

                queue.increment(number, addition);
            }
        }
    }
}
