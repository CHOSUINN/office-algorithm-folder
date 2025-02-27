package BOJ;

import java.util.Scanner;
import java.util.StringTokenizer;

// 체스판 칠하기
public class BOJ1018 {

    static  char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(sc.nextLine());
            char[] temp = st.nextToken().toCharArray();
            for (int j = 0; j < m; j++)
                arr[i][j] = temp[j];
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 8; i++)
            for (int j = 0; j <= m - 8; j++)
                answer = Math.min(answer, checkChessCnt(i, j));

        System.out.println(answer);
    }

    private static int checkChessCnt(int i, int j) {

        // w로 시작할때의 개수
        int cnt1 = 0;
        char curr = 'W';
        char check = 'W';
        for (int a = 0; a < 8; a++) {


            check = curr;
            for (int b = 0; b < 8; b++) {
                if (check != arr[i + a][j + b]) {
                    cnt1++;
                }
                check = (check == 'W') ? 'B' : 'W';
            }
            curr = (curr == 'W') ? 'B' : 'W';
        }

        // b로 시작할때의 개수
        int cnt2 = 0;
        curr = 'B';
        check = 'B';
        for (int a = 0; a < 8; a++) {

            check = curr;
            for (int b = 0; b < 8; b++) {
                if (check != arr[i + a][j + b]) {
                    cnt2++;
                }
                check = (check == 'W') ? 'B' : 'W';
            }
            curr = (curr == 'B') ? 'W' : 'B';
        }
        return Math.min(cnt1, cnt2);
    }
}
