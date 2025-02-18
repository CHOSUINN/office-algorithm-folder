package LiveClass.linkedList.연결큐;

public class LinkedQueue {
    public Node front;
    public Node tail;

    public void enQueue(int data) {
        Node node = new Node(data);
        if (front == null) {
            front = node;
            tail = node;
        } else {
            tail.link = node;
            tail = tail.link;
        }
    }

    public int deQueue() {
        if (front != null) {
            int data = front.data;
            front = front.link;
            return data;
        }

        return -1; // 문제에 따라 반환값 설정을 바꿔야함.ㄴ
    }

}
