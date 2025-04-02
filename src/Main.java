<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최소 스패닝 트린
public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken()) + 1;
        int E = Integer.parseInt(st.nextToken());

        int[][] map = new int[V][V];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[s][e] = cost;
            map[e][s] = cost;
=======
import java.util.Scanner;

public class Solution1_햄스터 {
    static int T, N, M, X, max;

    static class Recode {
        int st, ed, sum;

        public Recode(int st, int ed, int sum) {
            this.st = st;
            this.ed = ed;
            this.sum = sum;
>>>>>>> 325a27daaac56c89f04df393eda9b482f38d530f
        }
    }

<<<<<<< HEAD
        p = new int[V];
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = INF;
            p[i] = -1;
        }

        dist[0] = 0;
        int answer = 0;

        for (int i = 0; i < V; i++) {
            int min = INF;
            int idx = -1;

            for (int j = 0; j < V; j++) {
                if (!visited[j] && min > dist[j]) {
                    min = dist[j];
                    idx = j;
                }
            }

            if (idx == -1) {
                break;
            }

            visited[idx] = true;
            answer += dist[idx];

            for (int j = 0; j < V; j++) {
                if (map[idx][j] != 0 && !visited[j] && dist[j] > map[idx][j]) {
                    dist[j] = map[idx][j];
                    p[j] = idx;
                }
            }

        }

        System.out.println(answer);


    }



=======
    static Recode[] recodes;
    static int[] cage;
    static int[] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            max = -1;
            N = sc.nextInt();// 우리수
            X = sc.nextInt();// 한 우리의 최대 X마리
            M = sc.nextInt();// 기록 M개
            recodes = new Recode[M];
            cage = new int[N + 1];
            ans = new int[N + 1];

            for (int i = 0; i < M; i++) {
                int st = sc.nextInt();
                int ed = sc.nextInt();
                int sum = sc.nextInt();
                recodes[i] = new Recode(st, ed, sum);
            }

            DFS(1, 0);

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");
            if (max == -1) {
                sb.append("-1");
            } else {
                for (int i = 1; i <= N; i++) {
                    sb.append(ans[i]).append(" ");
                }
            }
            System.out.println(sb);
        }

    }

    static void DFS(int idx, int cnt) {
        if (idx > N) {

            for (int i = 0; i < M; i++) {
                Recode curr = recodes[i];
                int tmp = 0;
                for (int j = curr.st; j <= curr.ed; j++) {
                    tmp += cage[j];
                }
                if (tmp != curr.sum) {
                    return;
                }
            }
            //갱신이 된다면 정답도 갱신
            if (max < cnt) {
                max = cnt;
                for (int i = 1; i <= N; i++)
                    ans[i] = cage[i];
            }
            return;
        }

        for (int i = 0; i <= X; i++) {
            cage[idx] = i;
            DFS(idx + 1, cnt + i);
        }
    }
>>>>>>> 325a27daaac56c89f04df393eda9b482f38d530f
}
