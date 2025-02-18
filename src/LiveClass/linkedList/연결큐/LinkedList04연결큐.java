package LiveClass.linkedList.연결큐;

public class LinkedList04연결큐 {
    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }
}
