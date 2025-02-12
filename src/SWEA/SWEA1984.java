package SWEA;

import java.util.Scanner;

public class SWEA1984 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int sumUp;
        int max;
        int min;
        int[] arr;
        for (int i = 0; i < t; i++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            arr = new int[10];
            sumUp = 0;

            for (int j = 0; j < 10; j++)
                arr[j] = sc.nextInt();

            for (int j = 0; j < 10; j++) {
                if (max < arr[j]) max = arr[j];
                sumUp += arr[j];
            }

            for (int j = 0; j < 10; j++)
                if (min > arr[j]) min = arr[j];

            sumUp -= max;
            sumUp -= min;
            System.out.printf("#%d %d\n", i + 1, Math.round((float) sumUp /8));
        }
    }
}
