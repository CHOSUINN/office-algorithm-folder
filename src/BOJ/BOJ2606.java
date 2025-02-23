package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

// 바이러스
public class BOJ2606 {

    static int n, m;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(sc.nextLine());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(sc.nextLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }

        visited = new boolean[n + 1];
        int answer = bfs(1);
        System.out.println(answer);
    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        int cnt = 0;

        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i] && map[temp][i] == 1) {
                    q.offer(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
