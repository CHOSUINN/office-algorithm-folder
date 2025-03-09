package BOJ;

import java.io.*;
import java.util.StringTokenizer;

// 막대기
public class BOJ1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int x = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while (x > 0) {
            cnt += x & 1;
            x >>= 1;
        }

        bw.write(cnt + "\n");
        bw.flush();
    }
}
