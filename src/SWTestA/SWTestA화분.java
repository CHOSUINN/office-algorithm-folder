package SWTestA;

import java.util.Scanner;

// A형 시험 1번 문제 화분
public class SWTestA화분 {

    static int[] arr1;
    static int[] arr2;
    static int n;
    static int p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < tc; t++) {
            String[] input = sc.nextLine().split(" ");
            n = Integer.parseInt(input[0]);
            p = Integer.parseInt(input[1]);

            String[] input1 = sc.nextLine().split(" ");
            String[] input2 = sc.nextLine().split(" ");

            arr1 = new int[n];
            arr2 = new int[n];
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(input1[i]);
                arr2[i] = Integer.parseInt(input2[i]);
            }

            // 1번 비료로 시작
            int answer1 = dfs(n, 0, 1);
            // 2번 비료로 시작
            int answer2 =dfs(n, 0, 2);
            int answer = Math.max(answer1, answer2);

            System.out.printf("#%d %d\n", t + 1, answer);
        }

    }

    private static int dfs(int n, int index, int flag) {
        if (index == (n - 1))
            if (flag == 1) {
                return Math.max(arr1[index] - p, arr2[index]);
            } else {
                return Math.max(arr1[index], arr2[index] - p);
            }

        else
            if (flag == 1) {
                int x = dfs(n, index + 1, 1);
                int y = dfs(n, index + 1, 2);
                return Math.max(arr1[index] - p + x, arr2[index] + y);
            } else {
                int x = dfs(n, index + 1, 1);
                int y = dfs(n, index + 1, 2);
                return Math.max(arr1[index] + x, arr2[index] - p + y);
            }

    }
}
