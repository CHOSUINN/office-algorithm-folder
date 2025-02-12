package SWEA;

import java.util.*;

public class SWEA1208 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            int n = sc.nextInt();
            int[] arr = new int[100];

            for (int j = 0; j < 100; j++) {
                arr[j] = sc.nextInt();
            }

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int cnt = 0;
            while (cnt < n) {
                Arrays.sort(arr);
                arr[0]++;
                arr[99]--;
                cnt++;

                if (arr[99] > arr[98]) {
                    max = arr[99];
                } else {
                    max = arr[98];
                }

                if (arr[0] > arr[1]) {
                    min = arr[1];
                } else {
                    min = arr[0];
                }
            }

            System.out.printf("#%d %d\n", i + 1, max - min);

        }

    }
}
