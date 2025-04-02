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
        }

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



}
