//import java.util.*;
//
//// 케빈 베이컨의 6단계 법칙
//public class BOJ1389 {
//
//    static List<List<Integer>> relationShip;
//    static boolean[] visited;
//    static List<List<int[]>> answer;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        String[] input = sc.nextLine().split(" ");
//        int n = Integer.parseInt(input[0]);
//        int m = Integer.parseInt(input[1]);
//
//        relationShip = new ArrayList<>();
//
//        for (int i = 0; i < n; i++)
//            relationShip.add(new ArrayList<>());
//
//        for (int i = 0; i < m; i++) {
//            String[] inputAB = sc.nextLine().split(" ");
//            int a = Integer.parseInt(inputAB[0]);
//            int b = Integer.parseInt(inputAB[1]);
//
//            relationShip.get(a - 1).add(b - 1);
//        }
//
//        answer = new ArrayList<>();
//        for (int i = 0; i < n; i++)
//            answer.get(i).add(new int[]{0, 0});
//
//        for (int i = 0; i < n; i++) {
//            visited = new boolean[n];
//            bfs(i);
//        }
//
//    }
//
//    private static void bfs(int start) {
//        Queue<Integer> q = new LinkedList<>();
//        q.offer(start);
//        visited[start] = true;
//        int cnt = 1;
//
//        while (!q.isEmpty()) {
//            int len = q.size();
//            for (int i = 0; i < len; i++) {
//                int temp = q.poll();
//                for (int a : relationShip.get(temp)) {
//                    if (!visited[a])
//                        q.offer(a);
//                    answer[temp][a] = Math.min(answer[temp][a], cnt);
//                }
//            }
//            cnt++;
//        }
//
//
//
//    }
//
//}