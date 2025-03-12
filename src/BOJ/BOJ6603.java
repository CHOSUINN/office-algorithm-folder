package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 로또
public class BOJ6603 {

    static StringBuilder sb;
    static final int LOTTO_LEN = 6;
    static int[] sel;
    static int[] arr;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            arr = new int[k];
            for (int i = 0; i < k; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            sel = new int[LOTTO_LEN];
            findComb(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);


    }

    private static void findComb(int idx, int arrIdx) {

        if (idx == LOTTO_LEN) {
            for (int i = 0; i < LOTTO_LEN; i++) {
                sb.append(sel[i]).append(" ");
            }
            sb.append("\n");
            return;

        }

        if (arrIdx == k) return;

        sel[idx] = arr[arrIdx];
        findComb(idx + 1, arrIdx + 1);

        findComb(idx, arrIdx + 1);
    }
}
