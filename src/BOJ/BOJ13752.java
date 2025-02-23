package BOJ;

import java.util.Scanner;

// 히스토그램
public class BOJ13752 {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < n; i++)
                sb.append("=");

            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
