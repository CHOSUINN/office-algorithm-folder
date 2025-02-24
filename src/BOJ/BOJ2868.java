package BOJ;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 1 + (V - A) / (A - B)
 * V - A가 낮에 끝나는 계산을 한거기 떼문에 1을 더해준다.
 */
// 달팽이는 올라가고 싶다
public class BOJ2868 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int answer = ((v - a) % (a - b) != 0) ? 1 + 1 + (v - a) / (a - b) : 1 + (v - a) / (a - b);

        System.out.println(answer);
    }
}