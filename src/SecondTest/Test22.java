package SecondTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] arr;
        int answer;

        int tc = Integer.parseInt(sc.nextLine());


        for (int t = 0; t < tc; t++) {
            String[] input = sc.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            answer = 0;
            arr = new char[n][m];

            for (int i = 0; i < n; i++) {
                char[] inputs = sc.nextLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = inputs[j];
                }
            }

            // 첫, 마지막 줄부터 계산
            for (int i = 0; i < m; i++) {
                if (arr[0][i] != 'W') answer++;
                if (arr[n - 1][i] != 'R') answer++;
            }


            if (n > 3) {
                int index = 1;
                while (index < n - 2) {

                    int cnt = 0;
                    int wCnt = 0;
                    int bCnt = 0;
                    int rCnt = 0;
                    for (int i = 0; i < m; i++) {
                        if (arr[index][i] == 'W') wCnt++;
                        if (arr[index][i] == 'B') bCnt++;
                        if (arr[index][i] == 'R') rCnt++;
                    }
                    int temp = Math.max(wCnt, Math.max(bCnt, rCnt));
                }

            } else {
                for (int i = 0; i < m; i++)
                    if (arr[1][i] != 'B') answer++;
            }


            System.out.printf("#%d %d", t + 1, answer);
        }

    }

}
