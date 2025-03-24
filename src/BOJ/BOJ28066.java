package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 타노스는 요세푸스가 밉다
public class BOJ28066 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 1; i <= n; i++)
            deque.offer(i);

        while (deque.size() > 1) {

            if (deque.size() == 1) {
                sb.append(deque.peek());
                break;
            }

            if (deque.size() <= k) {
                sb.append(deque.poll());
                break;
            }

            int temp = deque.poll();
            deque.offer(temp);
            for (int i = 0; i < k - 1; i++)
                deque.poll();


        }


        System.out.println(sb);


    }
}
