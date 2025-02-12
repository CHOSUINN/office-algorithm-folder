package SWEA;

import java.util.Scanner;

public class SWEA2068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int maxNum;
        for (int i = 0; i < t; i++) {
            maxNum = Integer.MIN_VALUE;
            for (int j = 0; j < 10; j++) {
                int a = sc.nextInt();
                if (maxNum < a) maxNum = a;
            }

            System.out.printf("#%d %d\n", i + 1, maxNum);
        }
    }
}
