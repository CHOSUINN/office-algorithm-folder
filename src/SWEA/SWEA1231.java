package SWEA;

import java.util.Scanner;

// 후위순회
public class SWEA1231 {

    static int[][] tree;
    static char[] val;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 0; t < 10; t++) {
            n = Integer.parseInt(sc.nextLine());
            tree = new int[n][2]; // [0] 왼쪽 자식, [1] 오른쪽 자식
            val = new char[n];

            for (int i = 0; i < n; i++) {
                String[] input = sc.nextLine().split(" ");

                val[i] = input[1].charAt(0);
                for (int j = 2; j < input.length; j++) {
                    tree[i][j - 2] = Integer.parseInt(input[j]) - 1;
                }
            }

            System.out.printf("#%d ", t + 1);
            inOrder(0);
            System.out.println();

        }
    }

    static void inOrder(int value) {
        if (value >= n) return;

        if (tree[value][0] != 0)
            inOrder(tree[value][0]);

        System.out.print(val[value]);

        if (tree[value][1] != 0)
            inOrder(tree[value][1]);

    }
}
