package LiveClass.heap;


import java.util.Arrays;

// 최대힙 구현
public class Heap01Array구현 {

    static int[] heap;
    static int heapSize;

    public static void main(String[] args) {

        // 문제
        heap = new int[100]; // 실제 문제 입력을 보고 판단
        heapSize = 0;

        System.out.println(Arrays.toString(heap));
        heapPush(10);
        System.out.println(Arrays.toString(heap));
        heapPush(20);
        System.out.println(Arrays.toString(heap));
        heapPush(15);
        System.out.println(Arrays.toString(heap));
        heapPush(19);
        System.out.println(Arrays.toString(heap));

        System.out.println(heapPop());
        System.out.println(heapPop());
        System.out.println(heapPop());
        System.out.println(heapPop());

    }

    // 힙 자료형에 맞게 아이템이 들어온다.
    public static void heapPush(int item) {
        heapSize += 1;
        heap[heapSize] = item; // 마지막 자리에 삽입

        int ch = heapSize;
        int p = ch / 2; // 버림이 필요한데, 정수형이라 버려진다.

        // 올릴 수 있으면 노드를 올라가게 한다(정렬)
        while (p > 0 && heap[p] < heap[ch]) {
            int temp = heap[p];
            heap[p] = heap[ch];
            heap[ch] = temp;

            ch = p;
            p = ch / 2;
        }
    }


    public static int heapPop() {
        // 힙이 공백이면
        if (heapSize <= 0)
            return -1;  // 문제에 따라 바꿔야함.

        int item = heap[1];
        // 배열 맨 뒤에 있는 노드를 루트 자리로 이동시킨다
        heap[1] = heap[heapSize];
        heapSize -= 1;

        int p = 1;
        int ch = p * 2;
        if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) {
            ch += 1;
        }

        // 루트노드부터 내려갈 수 있으면 내려보낸다(정렬)
        while (ch <= heapSize && heap[p] < heap[ch]) {
            int temp = heap[p];
            heap[p] = heap[ch];
            heap[ch] = temp;

            p = ch;
            ch = p * 2; // 왼쪽 자식 세팅
            if (ch + 1 <= heapSize && heap[ch] > heap[ch + 1]) {
                ch += 1; // 오른쪽 자식 세팅
            }
        }

        return item;
    }





}
