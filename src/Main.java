import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static int[] result;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N]; // 입력 받는 수
        result = new int[M]; // 뽑을 순열 배열

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        permutation(0);
        System.out.println(sb);

    }

    static void permutation(int idx) {
        if (idx == M) {         // result 배열
            for (int i = 0; i < M; i++) {
//                System.out.print(result[i] + " ");
                sb.append(result[i]).append(" ");
            }
//            System.out.println();
            sb.append("\n");
            return;

        }

        for (int i = 0; i < N; i++) {    // arr 배열
            result[idx] = arr[i];
            permutation(idx + 1);
        }
    }


}
