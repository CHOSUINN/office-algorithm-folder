import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 타노스는 요세푸스가 밉다
public class BOJ28066 {

    static int answer;
    static int n;
    static int k;
    static boolean[] arr;
    static int left;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = true;
        }

        left = n;
        int index = 0;
        while (left > 1) {
            int ni = index + 1;
            if (ni > n)
                ni = 1;
            while (true) {

            }

        }

        System.out.println(answer);
    }
}
