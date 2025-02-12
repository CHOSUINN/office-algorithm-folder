import java.util.Scanner;

// 풍선팡
public class Test2 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        for (int t = 0; t < testCase; t++) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    arr[i][j] = sc.nextInt();

//            for (int[] ints : arr) {
//                for (int anInt : ints) {
//                    System.out.print(anInt);
//                }
//                System.out.println();
//            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int tempSum = arr[i][j];

                    int cnt = arr[i][j];
                    for (int k = 0; k < 4; k++)  {

                        int nx = i;
                        int ny = j;
                        for (int p = 0; p < cnt; p++) {

                            nx += dx[k];
                            ny += dy[k];

                            if (nx < 0 || nx >= n) continue;
                            if (ny < 0 || ny >= n) continue;
                            tempSum+=arr[nx][ny];

                        }


                    }

                    System.out.println(tempSum);
                    max = Math.max(max, tempSum);
                }
            }


            System.out.printf("#%d %d\n",t + 1, max);
        }
    }
}
