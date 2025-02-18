package SWEA;

import java.util.Scanner;

// 파리퇴치 3
public class SWEA12712 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = Integer.parseInt(sc.nextLine());
        int[][] arr;

        // 상하좌우대각선
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[] dxd = {-1, 1, -1, 1};
        int[] dyd = {-1, 1, 1, -1};

        for (int t = 0; t < tc; t++) {

            String[] inputs = sc.nextLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);

            arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] input = sc.nextLine().split(" ");
                for (int j = 0; j < n; j++)
                    arr[i][j] = Integer.parseInt(input[j]);
            }

            int answer = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    int cnt = arr[i][j];
                    int cntD = arr[i][j];
                    for (int k = 0; k < 4; k++) {
                        for (int p = 1; p < m; p++) {
                            int nx = i + dx[k] * p;
                            int ny = j + dy[k] * p;
                            if (nx < 0 || nx >= n) break;
                            if (ny < 0 || ny >= n) break;

                            cnt += arr[nx][ny];
                        }

                        for (int p = 1; p < m; p++) {
                            int nxd = i + dxd[k] * p;
                            int nyd = j + dyd[k] * p;

                            if (nxd < 0 || nxd >= n) break;
                            if (nyd < 0 || nyd >= n) break;

                            cntD += arr[nxd][nyd];
                        }
                    }
                    answer = ft_max(answer, ft_max(cnt, cntD));

                }
            }

            System.out.printf("#%d %d\n", t + 1, answer);
        }
    }

    private static int ft_max(int a, int b) {
        return (a > b) ? a : b;
    }
}
