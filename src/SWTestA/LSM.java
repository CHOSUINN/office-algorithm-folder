package SWTestA;

import java.util.Arrays;
import java.util.Scanner;

public class LSM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nTestCases = sc.nextInt();
        for (int caseNum = 1; caseNum <= nTestCases; caseNum++) {
            int nFlowers = sc.nextInt();
            int panelty = sc.nextInt();

            int[] first = new int[nFlowers];
            int[] second = new int[nFlowers];

            Arrays.setAll(first, i -> sc.nextInt());
            Arrays.setAll(second, i -> sc.nextInt());

            int[] firstSum = new int[nFlowers];
            int[] secondSum = new int[nFlowers];

            firstSum[0] = first[0];
            secondSum[0] = second[0];

            for (int i = 1; i < nFlowers; i++) {
                firstSum[i] = Math.max(firstSum[i - 1] - panelty, secondSum[i - 1]) + first[i];
                secondSum[i] = Math.max(firstSum[i - 1], secondSum[i - 1] - panelty) + second[i];
            }

            int res = Math.max(firstSum[nFlowers - 1], secondSum[nFlowers - 1]);

            System.out.println("#" + caseNum + " " + res);
        }

        sc.close();
    }
}
