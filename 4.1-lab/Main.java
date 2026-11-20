import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MinStackImpl stack = new MinStackImpl();

        while (scanner.hasNext()) {
            String command = scanner.next();

            if (command.equals("push")) {
                int value = scanner.nextInt();
                stack.push(value);
            } else if (command.equals("pop")) {
                stack.pop();
            } else if (command.equals("top")) {
                System.out.println(stack.top());
            } else if (command.equals("min")) {
                System.out.println(stack.min());
            }
        }
    }
}
