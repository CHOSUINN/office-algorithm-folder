import java.util.Scanner;

// 1,2,3 더하기
public class BOJ9095 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        for (int t = 0; t < testCase; t++) {
            int n = sc.nextInt();
            int answer = n - (n - 1) + (n - 1) + (n - 2);
            answer += (n % 2 == 0) ? 1 : 2;

            System.out.println(answer);
        }

    }
}
