package LiveClass.기초.linkedList.데크;

import java.util.ArrayDeque;
import java.util.Deque;

public class LinkedList07데크 {
    public static void main(String[] args) {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>();

        // 테스트
        deque.addFirst(10);
        System.out.println(deque.removeFirst());

        Deque<String> deque2 = new ArrayDeque<>();

        deque2.add(null);
        deque2.removeFirst();
    }
}
