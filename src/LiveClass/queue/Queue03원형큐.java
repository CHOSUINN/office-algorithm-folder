package LiveClass.queue;

import java.util.Arrays;

public class Queue03원형큐 {

    // 한칸을 비워둘 예정
    public static String[] cQ = new String[5];
    public static int front = 0, rear = 0;

    public static void main(String[] args) {
        System.out.println(enQueue("김도훈"));
        System.out.println(enQueue("박승연"));
        System.out.println(enQueue("강건"));
        System.out.println(enQueue("문하은"));

        // 맨 앞 값이 비워져 있을것이다.
        System.out.println(Arrays.toString(cQ));

        System.out.println(deQueue());
        System.out.println(enQueue("전지환"));
        System.out.println(Arrays.toString(cQ));
    }

    // 삽입
    public static boolean enQueue(String item) {
        if (isFull())
            return false;
        // 원형으로 만들어주기 위함
        rear = (rear + 1) % cQ.length;
        cQ[rear] = item;
        return true;
    }
    
    // 삭제
    public static String deQueue() {
        if (isEmpty())
            return null;
        front = (front + 1) % cQ.length;

        // 실제 데이터를 지우지 않음.
        // rear를 통해 데이터를 덮어쓰기 때문에 크게 상관이 없다.
        return cQ[front];
    }
    
    // 공백(선형큐와 동일)
    public static boolean isEmpty() {
        return front == rear;
    }
    
    // 포화(한칸을 비워 둠)
    public static boolean isFull() {
        return front == (rear + 1) % cQ.length;
    }
}
