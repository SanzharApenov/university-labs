public class MinStackImpl implements MinStack<Integer> {
    private Node head;

    public void push(Integer value) {
        Node node = new Node();
        node.value = value;
        node.min = value;

        if (head != null && head.min < value) {
            node.min = head.min;
        }

        node.next = head;
        head = node;
    }

    public Integer pop() {
        int value = head.value;
        head = head.next;
        return value;
    }

    public Integer top() {
        return head.value;
    }

    public Integer min() {
        return head.min;
    }
}
