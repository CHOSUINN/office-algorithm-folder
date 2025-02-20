import java.util.Scanner;

// 케빈 베이컨의 6단계 법칙
public class BOJ1389 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            String[] inputAB = sc.nextLine().split(" ");
            int a = Integer.parseInt(inputAB[0]);
            int b = Integer.parseInt(inputAB[1]);

            map[a][b] = 1;
            map[b][a] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || map[i][j] != 0) continue;

                int flag = 1; // 관계도 길이가 제일 작은 사람부터 시작 which is '1';
                int x = i;
                int y = j;
                while (true) {
                    int cnt = 1;
                    int minCnt = Integer.MAX_VALUE;
                    for (int k = 1; k <= n; k++) {
                        if (map[x][k] == flag) {
                            if (map[k][y] != 0) {
                                cnt += map[k][y];
                            } else {
                                break;
                            }
                        }
                    }

                }


            }
        }







    }



}
