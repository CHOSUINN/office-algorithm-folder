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
    static List<Edge> edges;
    static int[] dist;

    static class Edge {
        int num;
        int itemCnt;
        int cost;

        public Edge(int num, int itemCnt, int cost) {
            this.num = num;
            this.itemCnt = itemCnt;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 지역의 개수(정점)
        int m = Integer.parseInt(st.nextToken()); // 수색범위 
        int r = Integer.parseInt(st.nextToken()); // 길의 개수

        List<Edge>[] edges = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        dist = new int[n + 1];
        Arrays.fill(dist, INF);

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {

        }

        for (int i = 0; i < r; i++) {

        }
        
    }
}
