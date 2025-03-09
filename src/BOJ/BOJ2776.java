package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 암기왕
public class BOJ2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            HashMap<Integer, Integer> hm = new HashMap<>();

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                hm.put(num, 1);
            }

            st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (hm.containsKey(num))
                    sb.append(1);
                else
                    sb.append(0);
                sb.append("\n");
            }
            System.out.print(sb);
            sb.setLength(0);
        }

    }
}
