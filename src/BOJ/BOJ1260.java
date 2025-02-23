package BOJ;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

// 나는야 포켓몬 마스터 이다솜
public class BOJ1260 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> hm1 = new HashMap<>();
        HashMap<String, Integer> hm2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(sc.nextLine());
            String temp = st.nextToken();
            hm1.put(i + 1, temp);
            hm2.put(temp, i + 1);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(sc.nextLine());
            String temp = st.nextToken();
            char[] input = temp.toCharArray();
            if (input[0] >= '0' && input[0] <= '9') {
                sb.append(hm1.get(Integer.parseInt(temp)));
            } else {
                sb.append(hm2.get(temp));
            }

            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
