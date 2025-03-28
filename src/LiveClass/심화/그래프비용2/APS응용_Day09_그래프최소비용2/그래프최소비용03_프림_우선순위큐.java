package LiveClass.심화.그래프비용2.APS응용_Day09_그래프최소비용2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 그래프최소비용03_프림_우선순위큐 {

    static final int INF = Integer.MAX_VALUE;

    static class Edge implements Comparable<Edge> {

        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(input);

        int v = sc.nextInt(); // 정점 -> 0번부터 시작
        int E = sc.nextInt(); // 간선

        List<Edge>[] adj = new ArrayList[v];

        // 인접리스트를 생성해주자
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int cost = sc.nextInt();

            // 무향 그래프
            adj[s].add(new Edge(e, cost));
            adj[e].add(new Edge(s, cost));
        }

        int answer = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[v]; // 트리에 소속인지 아닌지 기록

        // 0번을 고름
        int pick = 1;
        pq.add(new Edge(0, 0)); // 이걸 넣어주면 아래 방법 3중하나를 돌리는 것과 같은 효과이다.
//        visited[0] = true;

//        // 방법1
//        for (int i = 0; i < adj[0].size(); i++) {
//            pq.add(adj[0].get(i));
//        }
//
//        // 방법2
//        for (Edge e : adj[0]) {
//            pq.add(e);
//        }
//
//        // 방법3
//        pq.addAll(adj[0]);

        while (pick < v) {
            Edge e = pq.poll();
            if (visited[e.to]) continue;

            answer += e.cost;
            visited[e.to] = true;
            pick++;

            pq.addAll(adj[e.to]);
        }



        System.out.println(answer);
    }

    static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
            + "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";


}
