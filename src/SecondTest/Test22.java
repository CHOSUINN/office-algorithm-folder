package SecondTest;

import java.util.Scanner;

// 러시아 국기 같은 깃발
public class Test22 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = Integer.parseInt(sc.nextLine());
        int answer = Integer.MAX_VALUE;

        for (int t = 0; t < tc; t++) {

            String[] inputs = sc.nextLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);

            char[][] arr = new char[n][m];
            for (int i = 0; i < n; i++) {
                char[] input = sc.nextLine().toCharArray();
                for (int j = 0; j < m; j++)
                    arr[i][j] = input[j];
            }

            for (int sep1 = 1; sep1 <= n - 1; sep1++) {
                for (int sep2 = sep1 + 1; sep2 <= n - 1; sep2++) {

                    char curr = 'W';

                    int cnt = 0;
                    for (int i = 0; i < n; i++) {

                        if (i == sep1 && curr == 'W')
                            curr = 'B';
                        else if (i == sep2 && curr == 'B')
                            curr = 'R';

                        for (int j = 0; j < m; j++) {
                            if (arr[i][j] != curr)
                                cnt++;
                        }
                    }
                    answer = Math.min(answer, cnt);
                }
            }
            System.out.println(answer + "정답");

        }

    }

}
