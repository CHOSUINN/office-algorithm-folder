import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 보물상자 비밀번호
public class SWEA5658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            List<String> answer = new ArrayList<>();

            st = new StringTokenizer(br.readLine(), " ");
            char[] input = st.nextToken().toCharArray();
            char[] container = new char[n * 2];
            int index = 0;
            for (int i = 0; i < n * 2; i++) {
                if (i == n) index = 0;
                container[i] = input[index++];
            }

            for (int i = 0; i < n * 2 - (n / 4); i++) {
                sb.append(container[i]);
                if (sb.length() == n / 4) {
                    answer.add(String.valueOf(sb));
                    sb.setLength(0);
                    i -= (n / 4 - 1);
                }
            }

            for (String s : answer) {
                System.out.print(s + " ");
            }
            System.out.println();


            for (int i = 0; i < answer.size(); i++) {
                for (int j = 1; j < answer.size(); j++) {
                    int numI = Integer.parseInt(answer.get(i), 16);
                    int numJ = Integer.parseInt(answer.get(j), 16);
                    if (numI < numJ) {
                        int temp = numI;
                        answer.set(i, Integer.toHexString(numJ));
                        answer.set(j, Integer.toHexString(temp));
                    }
                }
            }

            for (String s : answer) {
                System.out.print(s + " ");
            }

            int cnt = 1;
            index = 1;
            String temp = answer.get(0);
            while (true) {
                if (cnt == k) break;

                if (answer.get(index).equals(temp)) {
                    index++;
                    continue;
                }

                temp = answer.get(index);
                index++;
                cnt++;
            }

            System.out.println();
            int finalAnswer = Integer.parseInt(answer.get(index), 16);
            sb.setLength(0);
            sb.append("#").append(t + 1).append(" ").append(finalAnswer);
            System.out.println(sb);


        }

    }

}
