package LiveClass.heap;

import java.util.Collections;
import java.util.PriorityQueue;

// 우선순위 큐
public class Heap02PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);
        pq.add(20);
        pq.add(15);
        pq.add(19);

        // 디폴트는 최소힙이다.
        // 비교기준을 넣으면 최대힙으로 사용 가능
        // 값을 넣을때, 음수로 넣으면 최대힙으로 사용할 수 있다.
        // 단 꺼낼때 음수를 양수로 바꿔줘야 한다.
        pq.add(-10);
        pq.add(-20);
        pq.add(-15);
        pq.add(-19);

        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
}
