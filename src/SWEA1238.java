//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//// [S/W 문제해결 기본] 10일차 - Contact
//public class SWEA1238 {
//
//    static final int TC = 10;
//    static int[][] map;
//    static boolean[] visited;
//    static int answer;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();
//
//        for (int t = 0; t < TC; t++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int inputLen = Integer.parseInt(st.nextToken());
//            int start = Integer.parseInt(st.nextToken());
//
//            st = new StringTokenizer(br.readLine(), " ");
//            int[] inputs = new int[inputLen];
//            for (int i = 0; i < inputLen; i++)
//                inputs[i] = Integer.parseInt(st.nextToken());
//
//            map = new int[101][101];
//
//            for (int i = 0; i < inputLen; i += 2) {
//                int a = inputs[i];
//                int b = inputs[i + 1];
//
//                map[a][b] = 1;
//            }
//            answer = 0;
//            visited = new boolean[101];
//            call(start);
//
//            sb.append("#").append(t + 1).append(" ").append(answer);
//            System.out.println(sb);
//            sb.setLength(0);
//        }
//
//
//    }
//
//    private static void call(int start) {
//        Queue<Integer> q = new ArrayDeque<>();
//        q.add(start);
//        visited[start] = true;
//        List<Integer> lastCallList = new ArrayList<>(); // 각 단계마다 전화한 마지막 번호
//
//        while (!q.isEmpty()) {
//            int len = q.size();
//            lastCallList.clear();
//
//            for (int j = 0; j < len; j++) {
//
//                int temp = q.poll();
//
//                // 인접한 애들 전화걸기
//                for (int i = 1; i <= 100; i++) {
//                    if (map[temp][i] == 1 && !visited[i]) {
//                        q.offer(i);
//                        visited[i] = true;
//                        lastCallList.add(i);
//                    }
//                }
//            }
//        }
//
//        System.out.println(lastCallList.size());
//
//        int max = Integer.MIN_VALUE;
//        for (int num : lastCallList) {
//            if (num > max)
//                max = num;
//        }
//        answer = max;
//
//
//    }
//}
