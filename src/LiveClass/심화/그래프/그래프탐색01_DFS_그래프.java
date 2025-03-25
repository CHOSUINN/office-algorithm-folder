package LiveClass.심화.그래프;

import java.util.Scanner;
import java.util.Stack;

public class 그래프탐색01_DFS_그래프 {
    static int v, e; // 정점의 개수, 간선의 개수
    static int[][] adj; // 인접행렬
    static boolean[] visited;   // 방문체크

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();
        adj = new int[v + 1][v + 1];
        visited = new boolean[v + 1];

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            adj[a][b] = 1;
            adj[b][a] = 1;
        }

        dfs(1);
        System.out.println("----");
        visited = new boolean[v + 1];
        dfsStack(1);

    }

    static void dfs(int v) {
        visited[v] = true;
        System.out.println(v);

        for (int i = 1; i <= v; i++) {
            if (!visited[i] && adj[v][i] == 1) {
                dfs(i);
            }
        }
    }

    // v: 시작 정점
    static void dfsStack(int v) {
        // 정점만 담을거야
        Stack<Integer> stack = new Stack<>();
        stack.push(v); // 시작은 넣고 해

        while (!stack.isEmpty()) {
            int curr = stack.pop();

            if (!visited[curr]) {
                visited[curr] = true;
                System.out.println(curr);

                for (int i = v; i > 0; i--) {
                    if (!visited[i] && adj[curr][i] == 1)
                        stack.push(i);
                }
            }
        }

    }
}
