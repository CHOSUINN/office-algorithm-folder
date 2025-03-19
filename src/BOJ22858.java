import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 원상복구 (small)
public class BOJ22858 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] result = new int[n];
        int[] d = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++)
            result[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            int[] temp = new int[n];

            for (int j = 0; j < n; j++) {
                temp[d[j] - 1] = result[j];
            }
            result = Arrays.copyOf(temp, temp.length);
        }

        for (int i = 0; i < result.length; i++)
            sb.append(result[i]).append(" ");
        System.out.println(sb);
    }
}
