package LiveClass.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Queue02API {
    public static void main(String[] args) {

        //인터페이스
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue2 = new ArrayDeque<>();
        
        // 추가
        queue.add(1);
        queue.offer(2);
        
        // 삭제
        queue.remove();
        queue.poll();
        
        // 조회
        queue.element();
        queue.peek();


        // 윗줄 삼총사 add, remove, element -> 예외를 발생시킴
        // 아랫줄 삼총사 offer, poll, peek -> 값을 리턴함.
        // queue에 아무것도 없는 상태에서 remove를 해보면 에러가 발생하는걸 볼 수 있다.
        // LinkedList의 remove함수를 확인해보면, removeFirst() 호출하는데, 얘는 NoSuchElementException를 던진다. NoSuchElementException를 확인해보면 아래 처럼 구현되어 있는걸 확인할 수 있다. NoSuchElementException RuntimeException을 상속 받고 있다. 즉, unchecked 예외처리를 하는 것이다.
        // private void checkElementIndex(int index) {
        //        if (!isElementIndex(index))
        //            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        //    }



    }

}
