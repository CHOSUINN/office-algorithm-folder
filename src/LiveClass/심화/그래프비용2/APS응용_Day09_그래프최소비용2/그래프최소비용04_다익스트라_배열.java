package LiveClass.심화.그래프비용2.APS응용_Day09_그래프최소비용2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 프림과 다익스트라는 거의 같다.
 * 갱신이 일어나는 부분에서 사소한 차이만 존재한다. 두 코드는 매우 유사하다.
 */
public class 그래프최소비용04_다익스트라_배열 {
    static class Edge {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int v, e; // 정점 0번부터, 간선
    static List<Edge>[] adj; // 인접리스트
    static int[] dist; // 거리저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(input);

        v = sc.nextInt();
        e = sc.nextInt();
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
        dist = new int[v];
        Arrays.fill(dist, INF);

        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int cost = sc.nextInt();

            adj[s].add(new Edge(e, cost)); //유향이기때문에 반대로 값을 또 넣을 필요가 없다.
        }

        dijkstra(0);
        System.out.println(Arrays.toString(dist));

    }

    private static void dijkstra(int start) {
        boolean[] visited = new boolean[v];

        dist[start] = 0; // 시작정점의 거리의 값을 0으로 갱신하겠다.

        // 정점의 수만큼 돈다.
        for (int i = 0; i < v - 1; i++) {
            // 1. 가장 작은 값을 뽑는다.
            int min = INF;
            int idx = -1;
            for (int j = 0; j < v; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    idx = j;
                }
            }

            // 더 이상의 진행은 무의미하기 때문에 -1일때 멈추게 한다.idx가 -1에서 시작하는데 최소값 갱신이 안된다면 더 진행할 필요가 없는것이다.
            if (idx == -1) break;

            visited[idx] = true;

            // 갱신 작업
            for (Edge e : adj[idx]) {
                // 방문하지 않았으면서, 갱신가능
                if (!visited[e.to] && dist[e.to] > dist[idx] + e.cost) {
                    dist[e.to] = dist[idx] + e.cost;
                }
            }


        }
    }

    static String input = "6 11\n" +
            "0 1 4\n" +
            "0 2 2\n" +
            "0 5 25\n" +
            "1 3 8\n" +
            "1 4 7\n" +
            "2 1 1\n" +
            "2 4 4\n" +
            "3 0 3\n" +
            "3 5 6\n" +
            "4 3 5\n" +
            "4 5 12\n";
}