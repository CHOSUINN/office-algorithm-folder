import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 에디터
public class BOJ1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Character> inputs = new ArrayList<>();
        String temp = st.nextToken();
        for (int i = 0; i < temp.length(); i++) {
            inputs.add(temp.charAt(i));
        }

        int cursor = inputs.size();
        st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String action = st.nextToken();
            switch (action) {
                case "L":
                    if (cursor != 0)
                        cursor--;
                    break;

                case "D" :
                    if (cursor < inputs.size())
                        cursor++;
                    break;

                case "B" :
                    if (cursor != 0) {
                        inputs.remove(cursor - 1);
                        cursor--;
                    }
                    break;

                case "P" :
                    inputs.add(cursor, st.nextToken().charAt(0));
                    cursor++;
                    break;
            }
        }

        for (Character input : inputs) {
            sb.append(input);
        }
        System.out.println(sb);



    }
}
