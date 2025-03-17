import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 숨바꼭질
public class BOJ1697 {

    static final int MAX_BOOLEAN = 100_001;
//    static boolean[] visited;
    static Set<Integer> visit;
    static int answer;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

//        visited = new boolean[MAX_BOOLEAN];
        visit = new HashSet<>();

        answer = bfs(n, 0);
        System.out.println(answer);
    }

    private static int bfs(int n, int cnt) {
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(n);
//        visited[n] = true;
        visit.add(n);


        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {

                int temp = q.poll();

                if (temp == k)
                    return cnt;

                if (temp - 1 >= 0 && temp - 1 < MAX_BOOLEAN && !visit.contains(temp - 1)) {
                    visit.add(temp - 1);
                    q.offer(temp - 1);
                }

                if (temp + 1 >= 0 && temp + 1 < MAX_BOOLEAN && !visit.contains(temp + 1)) {
                    visit.add(temp + 1);
                    q.offer(temp + 1);
                }

                if (temp * 2 >= 0 && temp * 2 < MAX_BOOLEAN && !visit.contains(temp * 2)) {
                    visit.add(temp * 2);
                    q.offer(temp * 2);
                }

            }

            cnt++;

        }
        return cnt;

    }
}
