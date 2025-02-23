package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 시간초과
 * dp + dfs로 풀어야하나..??
 * 1. Array,fill 사용. 매번 100,000이라는 메모리를 새로 할당하면 시간초과랑 연관이 있나..? 일단 도전해봄. 결과 안됨.
 * 2. 설마 또 너냐 스캐너? 결과 무진장 느리게 채점이 됨. 정답 뜨긴함.
 * 징글징글하다 스캐너. 너란놈..
 */

// 효율적인 해킹
public class BOJ1325 {

    static List<List<Integer>> map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new ArrayList<>();
        visited = new boolean[n];

        // 2차원 동적 배열 선언.
        for (int i = 0; i < n; i++)
            map.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(b - 1).add(a - 1);
        }

        // 1~n까지 각각 얼마나 해킹 되는지 수를 세서 저장
        int maxConnection = Integer.MIN_VALUE;
        int[] comNum = new int[n];
        for (int i = 0; i < n; i++) {
//            visited = new boolean[n];
            Arrays.fill(visited, false);
            comNum[i] = bfs(i);
            if (comNum[i] > maxConnection)
                maxConnection = comNum[i];
        }

        for (int i = 0; i < n; i++)
            if (maxConnection == comNum[i])
                System.out.print(i + 1 + " ");
    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        int cnt= 1;
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < map.get(temp).size(); i++) {
                if (!visited[map.get(temp).get(i)]) {
                    q.offer(map.get(temp).get(i));
                    visited[map.get(temp).get(i)] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}


/**
 * 메모리 초과
 * 2차원 배열을 사용한 풀이
 */

//import java.util.*;
//
//// 효율적인 해킹
//public class BOJ.BOJ1325 {
//
//    static int[][] map;
//    static boolean[] visited;
//    static int n, m;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        StringTokenizer st = new StringTokenizer(sc.nextLine());
//
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        map = new int[n + 1][n + 1];
//
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(sc.nextLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//
//            map[b][a] = 1;
//        }
//
//        int maxConnection = Integer.MIN_VALUE;
//        int[] comNum = new int[n + 1];
//        for (int i = 1; i < n + 1; i++) {
//            visited = new boolean[n + 1];
//            comNum[i] = bfs(i);
//            if (comNum[i] > maxConnection)
//                maxConnection = comNum[i];
//        }
//
//        List<Integer> answer = new ArrayList<>();
//        for (int i = 1; i < n + 1; i++) {
//            if (comNum[i] == maxConnection)
//                answer.add(i);
//        }
//
//        Collections.sort(answer);
//
//        for (int i = 0; i < answer.size(); i++) {
//            System.out.print(answer.get(i) + " ");
//        }
//
//    }
//
//    private static int bfs(int start) {
//        Queue<Integer> q = new LinkedList<>();
//        int cnt= 0;
//        q.add(start);
//        visited[start] = true;
//
//        while (!q.isEmpty()) {
//            int temp = q.poll();
//            cnt++;
//            for (int i = 1; i < n + 1; i++) {
//                if (!visited[i] && map[temp][i] == 1) {
//                    q.offer(i);
//                    visited[i] = true;
//                }
//            }
//
//        }
//        return cnt;
//    }
//
//}
