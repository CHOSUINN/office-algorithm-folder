package SWEA;

import java.util.Scanner;

// 거듭제곱
public class SWEA1217 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int t = 0; t < 10; t++) {
            int tc = sc.nextInt();

            int n = sc.nextInt();
            int m = sc.nextInt();

            int answer = ft_square(n, m);

            System.out.printf("#%d %d\n", t + 1, answer);


        }
    }

    private static int ft_square(int n, int m) {

        if (m == 0) {
            return 1;
        } else if (m == 1) {
            return n;
        } else {
            return n * ft_square(n, m - 1);
        }
    }

}
