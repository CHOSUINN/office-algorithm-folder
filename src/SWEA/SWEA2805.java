package SWEA;

import java.util.Scanner;

// 농작물 수확하기
public class SWEA2805 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < tc; t++) {

            int n = Integer.parseInt(sc.nextLine());
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] input = sc.nextLine().split("");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(input[j]);
                }

            }


            int mid = n / 2;
            int answer = 0;
            int lt = mid;
            int rt = mid;
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (i <= n / 2) {
                    for (int j = lt; j <= rt; j++) {
                        answer += arr[i][j];
                    }
                    lt -= 1;
                    rt += 1;
                } else {
                    if (flag) {
                        lt += 2;
                        rt -= 2;
                        flag = false;
                    }
                    for (int j = lt; j <= rt; j++) {
                        answer += arr[i][j];
                    }
                    lt += 1;
                    rt -= 1;
                }
            }

            System.out.printf("#%d %d\n", t + 1, answer);



        }
    }
}
