import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 문자열 지옥에 빠진 호석
public class BOJ20166 {

    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static char[][] arr;
    static List<List<Character>> check;
    static int n;
    static int m;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        check = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char[] input = st.nextToken().toCharArray();
            for (int j = 0; j < m; j++)
                arr[i][j] = input[j];
        }

        for (int i = 0; i < k; i++)
            check.add(new ArrayList<>());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            char[] inputs = st.nextToken().toCharArray();
            for (int j = 0; j < inputs.length; j++)
                check.get(i).add(inputs[j]);
        }

        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = bfs(i, check.get(i).size());
        }

        for (int i = 0; i < k; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.print(sb);

    }


    // check의 char배열을 돌면서 arr2차원 배열을 전부 돌거임. 만약 arr의 현재 위치가 check.get(index).get(i)와 계속 같은지 비교
    private static int bfs(int index, int checkLen) {
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == check.get(index).get(0)) {
                    q.offer(new int[]{i, j, 1});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            int depth = temp[2];

            if (depth == checkLen) {
                cnt++;
                continue;
            }

            for (int delta = 0; delta < 8; delta++) {
                int nr = r + dx[delta];
                int nc = c + dy[delta];

                if (nr >= n)
                    nr = nr % n;
                else if (nr < 0)
                    nr += n;

                if (nc >= m)
                    nc = nc % m;
                else if (nc < 0)
                    nc += m;

                if (arr[nr][nc] == check.get(index).get(depth)) {
                    q.offer(new int[]{nr, nc, depth + 1});
                }
            }
        }
        return cnt;

    }

}


/**
 * 너비 우선 탐색 시간초과.
 * n,m,k의 최대값에 문자열 길이 최대 5이기 때문에,
 * 10, 10, 1000이 들어온다고 생각하고 시간 복잡도를 계산해보면
 * O(10 * 10 * 8^5 * 1000)이다...
 * O(10^5 * 2^3*5) == O(10^5 * 2^15)랑 O(10^8) 비교했을때, 딱봐도 넘겨보이긴한다.
 * 종료조건을 조금 더 빨리 줄 방법이 있어야 하는데, 생각이 안남...
 * dfs + dp로 접근해서 다시 풀어야 할듯함.
 */
//public class BOJ20166 {
//
//    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
//    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
//    static char[][] arr;
//    static List<List<Character>> check;
//    static int n;
//    static int m;
//    static int k;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
//
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        k = Integer.parseInt(st.nextToken());
//        arr = new char[n][m];
//        check = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            char[] input = st.nextToken().toCharArray();
//            for (int j = 0; j < m; j++)
//                arr[i][j] = input[j];
//        }
//
//        for (int i = 0; i < k; i++)
//            check.add(new ArrayList<>());
//
//        for (int i = 0; i < k; i++) {
//            st = new StringTokenizer(br.readLine());
//            char[] inputs = st.nextToken().toCharArray();
//            for (int j = 0; j < inputs.length; j++)
//                check.get(i).add(inputs[j]);
//        }
//
//        int[] answer = new int[k];
//        for (int i = 0; i < k; i++) {
//            answer[i] = bfs(i, check.get(i).size());
//        }
//
//        for (int i = 0; i < k; i++) {
//            sb.append(answer[i]).append("\n");
//        }
//        System.out.print(sb);
//
//    }
//
//
//    // check의 char배열을 돌면서 arr2차원 배열을 전부 돌거임. 만약 arr의 현재 위치가 check.get(index).get(i)와 계속 같은지 비교
//    private static int bfs(int index, int checkLen) {
//        Queue<int[]> q = new LinkedList<>();
//        int cnt = 0;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (arr[i][j] == check.get(index).get(0)) {
//                    q.offer(new int[]{i, j, 1});
//                }
//            }
//        }
//
//        while (!q.isEmpty()) {
//            int[] temp = q.poll();
//            int r = temp[0];
//            int c = temp[1];
//            int depth = temp[2];
//
//            if (depth == checkLen) {
//                cnt++;
//                continue;
//            }
//
//            for (int delta = 0; delta < 8; delta++) {
//                int nr = r + dx[delta];
//                int nc = c + dy[delta];
//
//                if (nr >= n)
//                    nr = nr % n;
//                else if (nr < 0)
//                    nr += n;
//
//                if (nc >= m)
//                    nc = nc % m;
//                else if (nc < 0)
//                    nc += m;
//
//                if (arr[nr][nc] == check.get(index).get(depth)) {
//                    q.offer(new int[]{nr, nc, depth + 1});
//                }
//            }
//        }
//        return cnt;
//
//    }
//
//}
