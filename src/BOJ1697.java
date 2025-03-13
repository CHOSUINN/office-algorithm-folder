import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질
public class BOJ1697 {

    static boolean[] visited;
    static int answer;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[100_000];

        bfs(n);
        System.out.println(answer);
    }

    private static void bfs(int n) {
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(n);
        visited[n] = true;
        int len = q.size();
        answer = 1;

        while (!q.isEmpty()) {
            for (int i = 0; i < len; i++) {

                int temp = q.poll();

                if (temp == k)
                    break;

                if (temp - 1 > 0 && temp - 1 < n && !visited[temp - 1])
                    q.offer(temp - 1);

                if (temp + 1 > 0 && temp + 1 < n && !visited[temp + 1])
                    q.offer(temp + 1);

                if (temp * 2 > 0 && temp * 2 < n && !visited[temp * 2])
                    q.offer(temp * 2);

            }

            answer++;

        }

    }
}
