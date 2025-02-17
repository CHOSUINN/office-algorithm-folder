package SWEA;

import java.util.Scanner;

public class SWEA21936 {

    static char[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < tc; t++) {
            String[] nums = sc.nextLine().split(" ");
            int n = Integer.parseInt(nums[0]);
            int m = Integer.parseInt(nums[1]);
            arr = new char[n];
            sb.append("#");
            sb.append(t + 1);
            sb.append(" ");

            char[] input = sc.nextLine().toCharArray();
            for (int i = 0; i < input.length; i++)
                arr[i] = input[i];

            boolean flag = false;
            for (int i = 0; i <= input.length - m; i++) {
                if (palindrom(i, i + m - 1)) {
                    flag = true;
                    for (int j = i; j <= i + m - 1; j++)
                        sb.append(arr[j]);
                }

            }
            if (!flag)
                sb.append("NONE");

            System.out.println(sb);
            sb.setLength(0);


        }

    }

    private static boolean palindrom (int lt, int rt) {
        while (lt < rt) {
            if (arr[lt] != arr[rt])
                return false;
            lt++;
            rt--;
        }

        return true;
    }
}
