package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// n과 m(7)
public class BOJ15656 {

    static int[] sel;
    static int[] arr;
    static int n;
    static int m;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        sel = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        findComb(0);
        System.out.println(sb);
    }

    private static void findComb(int idx) {

        if (idx == m) {
            for (int j = 0; j < m; j++)
                sb.append(sel[j]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            sel[idx] = arr[i];
            findComb(idx + 1);
        }

    }
}
