import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 서강그러운드
public class BOJ14938 {

    static final int INF = Integer.MAX_VALUE;
    static int[] p;
    static List<Edge> edges;
    static int[] dist;
    static int[] item;
    static int n, m, r;

    static class Edge {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken()); // 지역의 개수(정점)
        m = Integer.parseInt(st.nextToken()); // 수색범위
        r = Integer.parseInt(st.nextToken()); // 길의 개수

        List<Edge>[] edges = new ArrayList[n + 1];  // 인접행렬
        for (int i = 0; i < n + 1; i++)
            edges[i] = new ArrayList<>();

        dist = new int[n + 1];
        p = new int[n + 1];
        item = new int[n + 1];
        Arrays.fill(dist, INF);


        // 노드별 아이템 저장
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n + 1; i++)
            item[i] = Integer.parseInt(st.nextToken());

        // 인접행렬 값 입력
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[a].add(new Edge(b, cost));
            edges[b].add(new Edge(a, cost));
        }

        dijkstra(0);



    }

    private static void dijkstra(int start) {
        boolean[] visited = new boolean[n + 1];

        dist[start] = 0;

        for (int i = 0; i < n; i++) {
            int min = INF;
            int idx = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    idx = j;
                }
            }



        }
    }
}
