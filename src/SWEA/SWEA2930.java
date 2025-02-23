package SWEA;

import java.util.Scanner;
import java.util.StringTokenizer;

// 힙 구현

/**
 * 최대힙을 구현한 상태.
 * 최소힙을 구현하고자 하면, add함수에서 if문의 부등호를 반대로 바꿔주면 된다.
 */
public class SWEA2930 {
    static int[] heap;
    static int size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            sb.append("#").append(t + 1);
            heap = new int[100001];
            size = 0;

            st = new StringTokenizer(sc.nextLine());
            int n = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(sc.nextLine());
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    int b = Integer.parseInt(st.nextToken());
                    add(b);
                } else
                    sb.append(" ").append(poll());
            }


            System.out.println(sb);
            sb.setLength(0);
        }
    }

    public static void add(int data) {
        heap[++size] = data;
        // 위로 올라갈 수 있는만큼 올라가야함.

        int ch = size;
        int p = size / 2;
        while (p > 0 && heap[p] < heap[ch]) {
            int temp = heap[ch];
            heap[ch] = heap[p];
            heap[p] = temp;

            ch = p;
            p = ch / 2;
        }
    }

    public static int poll() {
        if (size <= 0) {
            return -1;
        }

        int returnData = heap[1];

        heap[1] = heap[size--];
        // 루트 노드부터, 내려갈 수 있는 만큼 내려감

        int p = 1;
        int ch = p * 2;
        if (ch + 1 <= size && heap[ch] < heap[ch + 1])
            ch += 1;

        while (ch <= size && heap[p] < heap[ch]) {

            int temp = heap[ch];
            heap[ch] = heap[p];
            heap[p] = temp;

            p = ch;
            ch = p * 2;
            if (ch + 1 <= size && heap[ch] < heap[ch + 1])
                ch += 1;

        }

        return returnData;
    }
}


//
///**
// * 힙 기존 자료구조 사용해서 구현
// */
//// 힙
//public class SWEA2930 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        PriorityQueue<Integer> pq;
//        StringBuilder sb = new StringBuilder();
//
//        int tc = Integer.parseInt(sc.nextLine());
//        for (int t = 0; t < tc; t++) {
//            pq = new PriorityQueue<>(new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return o2 - o1;
//                }
//            });
//            sb.append("#").append(t + 1);
//
//            int n = Integer.parseInt(sc.nextLine());
//            for (int i = 0; i < n; i++) {
//                String[] inputs = sc.nextLine().split(" ");
//                if (Integer.parseInt(inputs[0]) == 1) {
//                    // 자연수 x 삽입
//                    pq.offer(Integer.parseInt(inputs[1]));
//                } else {
//                    // 최댓값 출력 후 해당 키값 삭제
//                    if (!pq.isEmpty()) {
//                        int a = pq.poll();
//                        sb.append(" ").append(a);
//                    } else
//                        sb.append(" ").append(-1);
//                }
//            }
//
//            System.out.println(sb);
//            sb.setLength(0);
//        }
//    }
//
//}
