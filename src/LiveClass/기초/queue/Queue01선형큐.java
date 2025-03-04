package LiveClass.기초.queue;

public class Queue01선형큐 {

    public static int[] queue = new int[10];
    public static int front = -1; // 데이터 삭제 위치
    public static int rear = -1; // 데이터 삽입 위치

    public static void main(String[] args) {
    }
        
    // 삽입
    public static void enQueue(int item) {
        if (isFull())
            return;
        queue[++rear] = item;
    }

    // 삭제
    public static int dequeue() {
        if (isEmpty())
            return 0;
        return queue[++front];
    }
        
    // 공백
    public static boolean isEmpty() {
        return front == rear;
    }

    // 포화(배열로 선언해 놓았기 때문에 한다)
    public static boolean isFull() {
        return rear == queue.length - 1;
    }

}
