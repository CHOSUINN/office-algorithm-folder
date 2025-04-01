
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int s, e, cost;

    public Edge(int s, int e, int cost) {
        this.s = s;
        this.e = e;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "s=" + s +
                ", e=" + e +
                ", cost=" + cost +
                '}';
    }
}

// 최소 스패닝 트리
public class BOJ1197 {


    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[E];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(s, e, cost);
        }

        Arrays.sort(edges);

        p = new int[V + 1];

        for (int i = 0; i < V; i++) {
            makeSet(i);
        }

        int answer = 0;
        int pick = 0;
        for (int i = 0; i < E; i++) {
            int s = edges[i].s;
            int e = edges[i].e;

            if (findSet(s) != findSet(e)) {
                union(s, e);
                pick++;
                answer += edges[i].cost;
            }

            if (pick == V - 1)
                break;
        }
        System.out.println(answer);

    }

    private static void union(int x, int y) {
        p[findSet(y)] = findSet(x);
    }

    private static int findSet(int x) {

//        if (x == p[x])
//            return x;
//        return findSet(p[x]);

        if (x != p[x])
            p[x] = findSet(p[x]);
        return p[x];
    }

    private static void makeSet(int x) {
        p[x] = x;
    }

}






