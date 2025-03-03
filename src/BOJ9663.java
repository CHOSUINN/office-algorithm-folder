import java.io.*;
import java.util.StringTokenizer;

// N-Queen
public class BOJ9663 {

    static int n;
    static int answer;
    static int[][] arr;
    static boolean flag = false;
    static boolean[] visited;
    // 좌우상하 좌상,우상, 좌하, 우하 대각선들
    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            flag = false;
            dfs(i, 1, n);
        }
        System.out.println(answer);

    }

    private static void dfs(int start, int depth, int goalDepth) {
        visited[start] = true;

        if (depth == goalDepth) {
            flag = true;
            return;
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(i, depth + 1, goalDepth);
                }
            }
        }
        visited[start] = false;
    }
}