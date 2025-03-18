import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 카드 1
public class BOJ2161 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for (int i = 1; i <= n; i++)
            arr[i - 1] = i;

        int cnt = n;
        int idx = 0;
        while (cnt != 1) {

            // 카드 버리기
            sb.append(arr[idx]).append(" ");
            arr[idx] = 0;
            cnt--;

            // 두칸 이동하기
            int move = 0;
            while (move != 2) {

                idx++;
                if (idx >= n)
                    idx = 0;
                if (arr[idx] == 0)
                    continue;

                move++;
            }
        }
        sb.append(arr[idx]);

        System.out.println(sb);


    }

}


/**
 * deque풀이
 */
//public class BOJ2161 {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        int n = Integer.parseInt(st.nextToken());
//        Deque<Integer> deque = new ArrayDeque<>();
//        for (int i = 1; i <= n; i++)
//            deque.add(i);
//
//        while (deque.size() != 1){
//            sb.append(deque.poll()).append(" ");
//            deque.offer(deque.poll());
//        }
//
//        sb.append(deque.poll());
//        System.out.println(sb);
//    }
//
//}
