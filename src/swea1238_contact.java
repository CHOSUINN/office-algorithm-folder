import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class swea1238_contact {

    static boolean[] visited;
    static int[][] matrix;
    static int maxVal;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = 2;
        for (int t = 1; t <= T; t++) {

            visited = new boolean[101];
            matrix = new int[101][101];

            int N = sc.nextInt();
            int start = sc.nextInt();

            for (int i = 0; i < N; i += 2) {
                int from = sc.nextInt();
                int to = sc.nextInt();

                matrix[from][to] = 1;
            }

            // for (int i = 0; i < 101; i ++) {
            //     for (int j = 0; j < 101; j++) {
            //         System.out.print(matrix[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            bfs(start);

            System.out.println("정답" + maxVal);

        }

    }

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(start);

        visited[start] = true;

        while (!queue.isEmpty()) {

            // 큐 크기 재고 그만큼 돌아야 됨
            int len = queue.size();

            maxVal = Integer.MIN_VALUE;
            for (int idx = 0; idx < len; idx++) {
                for (int i = 0; i < 101; i++) {
                    if (matrix[start][i] == 1 && !visited[i]) {
                        visited[i] = true;
                        queue.add(i);
                    }
                    maxVal = Math.max(maxVal, i);
                }
            }

            
        }
    }
}
