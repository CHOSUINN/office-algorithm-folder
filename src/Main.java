import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        int T = sc.nextInt();
        int N = sc.nextInt();
        int K = sc.nextInt();
        int result = 0;     // 총 몇 개의 단어를 입력할 수 있는지

        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (matrix[i][j] == 1) {
                    // 만약 2차원 배열에서 값을 입력할 수 있는 부분이 나왔다면

                    // 세로 검사
                    int sum1 = 0;
                    for (int x = i; x < i + K; x++) {
                        if (x < N) {
                            if (matrix[x][j] == 1) {
                                sum1 += matrix[x][j];
                            } else {
                                break;
                            }
                        }
                        if (sum1 == K) {
                            if (i + K <= N)
                                result++;
                            else
                                if (matrix[i + K][j] != 1)
                                    result++;
                        }

                    }

                }

            } // 전체 2차원 배열 돌아
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (matrix[i][j] == 1) {

                    // 가로 검사
                    int sum2 = 0;
                    for (int y = j; y < j + K; y++) {
                        if (y < N) {
                            if (matrix[i][y] == 1) {
                                sum2 += matrix[i][y];
                            } else {
                                break;
                            }
                        }

                        if (sum2 == K) {
                            if (j + K <= N)
                                result++;
                            else
                                if (matrix[i][j + K] == 1)
                                    break;
                                result++;
                        }

                    }
                }
            }

        }

        System.out.println(result);
    }
}
