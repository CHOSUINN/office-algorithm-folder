//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//// 연결 요소의 개수
//public class BOJ11724 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        StringBuilder sb = new StringBuilder();
//
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        int[][] map = new int[n][n];
//
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//
//            map[a][b] = 1;
//            map[b][a] = 1;
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (!visited[i][j])
//                    dfs(i, j);
//            }
//        }
//
//
//    }
//}
