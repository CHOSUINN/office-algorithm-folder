import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

// 화섭이의 미생물 배양
public class SWEA7194 {

    static int s, t, a, b;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int test = 1; test <= tc; test++) {
            s = sc.nextInt();
            t = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();

            visited = new boolean[t * b];
            int answer = bfs(s);

            System.out.println("#" + test + " " + answer);
        }
    }

    private static int bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        int depth = 1;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int temp = q.poll();
                if (temp == t)
                    return depth;
                if (temp > t)
                    continue;

                int temp1 = temp + a;
                int temp2 = temp * b;
                if (!visited[temp1] && t > temp1) {
                    visited[temp1] = true;
                    q.add(temp1);
                }
                if (!visited[temp2] && t > temp2) {
                    visited[temp2] = true;
                    q.add(temp2);
                }
            }
            depth++;

        }

        return -1;


    }
}



//import java.util.Scanner;
//
//// 화섭이의 미생물 배양
//public class SWEA7194 {
//
//    static int s, t, a, b;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int tc = sc.nextInt();
//        for (int test = 1; test <= tc; test++) {
//            s = sc.nextInt();
//            t = sc.nextInt();
//            a = sc.nextInt();
//            b = sc.nextInt();
//
//            int answer = dfs(s, 0);
//
//            System.out.println("#" + test + " " + answer);
//        }
//    }
//
//    private static int dfs(int start, int depth) {
//
//        if (start == t)
//            return depth;
//        if (start > t)
//            return -1;
//
//        dfs(start + a, depth + 1);
//
//        dfs(start * b, depth + 1);
//        return -3;
//    }
//}
