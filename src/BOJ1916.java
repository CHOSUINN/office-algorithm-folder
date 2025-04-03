import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//최소비용 구하기
public class BOJ1916 {

    static class Edge implements Comparable<Edge>{
        int to, cost;

        public Edge(int v, int w) {
            this.to = v;
            this.cost = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static List<Edge>[] adjList;
    static int n, m;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        dist = new int[n];
        Arrays.fill(dist, INF);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            adjList[s].add(new Edge(e, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        dijkstra(start);

        System.out.println(dist[end]);

    }

    private static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n];

        dist[start] = 0;

        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (visited[curr.to])
                continue;
            visited[curr.to] = true;

            for (Edge node : adjList[curr.to]) {
                if (!visited[node.to] && dist[node.to] > dist[curr.to] + node.cost) {
                    dist[node.to] = dist[curr.to] + node.cost;
                    pq.add(new Edge(node.to, dist[node.to]));
                }
            }
        }

    }
}
