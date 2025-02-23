package BOJ;

import java.util.Scanner;

// 이항 계수 1
public class BOJ11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] inputs = sc.nextLine().split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);

        int bunja = 1;
        for (int i = 0; i < b; i++)
            bunja *= (a - i);

        int bunmo = 1;
        for (int i = 1; i <= b; i++)
            bunmo *= i;

        int answer = bunja / bunmo;
        System.out.println(answer);
    }
}
