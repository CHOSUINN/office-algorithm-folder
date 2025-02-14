package SecondTest;

import java.util.Scanner;

// 러시아 국기 같은 깃발
public class Test2 {
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


            /**
             * 국기가 3줄이면 가운데는 반드시 'B'여야한다.
             * 3이상일때 최소값 찾기
             * flag를 통해서 이제부터는 빨간색으로만 칠해야하는지 여부를 확인
             * 2번째 줄부터(i == 1), w의 개수 vs b의 개수. 만약 w가 많으면, 다음 줄이 마지막 두번째 줄인지 확인.
             * 마지막 두번째 줄이면 반드시 그 줄은 b로 칠해야함.
             * 해당 줄을 w로 칠하는것보다 b가 많더라도 b로 칠하고 나머지 아래칸들을 r로 칠하는게 더 나을 경우도 생각해야함.
             * 방법1. 두번째 줄부터 마지막 두번째 줄까지, b로 칠했을때, 최소가 되는 줄을 찾아. 해당 줄을 기준으로 2번째 줄부터, w가 어디까지 칠해야하는지 비교, 아래도 b와 r을 비교.
             */
            if (n > 3) {
                // b를 칠했을때, 최소가 되는 줄 찾기
                int index = Integer.MAX_VALUE;
                int min = Integer.MAX_VALUE;
                for (int i = 2; i < n - 1; i++) {
                    int cnt = 0;
                    for (int j = 0; j < m; j++) {
                        if (arr[i][j] != 'B') cnt++;
                    }
                    if (cnt < min) {
                        min = cnt;
                        index = i;
                    }
                }
                answer += min;

                // 2번째 줄부터 b가 칠해진 줄까지, i -> index 줄까지 w가 많은지 b가 많은지 비교.
                // 깃발 == true면 이후부터는 b 혹은 r로 칠함
                boolean flag = false;
                for (int i = 2; i < index; i++) {

                    if (!flag) {
                        int wCnt = 0;
                        int bCnt = 0;
                        for (int j = 0; j < m; j++) {
                            // w가 아닌칸의 수 vs b가 아닌칸의 수
                            if (arr[i][j] != 'W') wCnt++;
                            if (arr[i][j] != 'B') bCnt++;
                        }
                        // b보다 w로 칠했을때 더 최솟값인 경우 해당 줄을 w로 칠함.
                        if (wCnt <= bCnt) {
                            answer += wCnt;
                        } else {
                            flag = true;
                            answer += bCnt;
                        }
                    } else {
                        // 만약 한줄이라도 'b'로 칠하는게 나으면 그 줄부터는 'b'로 색칠
                        for (int j = 0; j < m; j++)
                            if (arr[i][j] != 'B')
                                answer++;
                    }

                }

                // index줄부터 n - 1줄까지 b가 많은지 r이 많은지.
                flag = false;
                for (int i = index + 1; i < n - 1; i++) {
                    if (!flag) {
                        int bCnt = 0;
                        int rCnt = 0;
                        for (int j = 0; j < m; j++) {
                            if (arr[i][j] != 'B') bCnt++;
                            if (arr[i][j] != 'R') rCnt++;
                        }

                        if (bCnt < rCnt) {
                            answer += bCnt;
                        } else {
                            flag = true;
                            answer += rCnt;
                        }
                    } else {
                        for (int j = 0; j < m; j++)
                            if (arr[i][j] != 'R')
                                answer++;
                    }
                }

                int wCnt = 0;
                int bCnt = 0;
                for (int x = 0; x < m; x++) {
                    if (arr[1][x] != 'W') wCnt++;
                    if (arr[1][x] != 'B') bCnt++;

                }

                if (wCnt <= bCnt) {
                    answer += wCnt;
                } else {

                }

            } else {
                for (int i = 0; i < m; i++)
                    if (arr[1][i] != 'B') answer++;
            }


            System.out.printf("#%d %d", t + 1, answer);
        }

    }
}
