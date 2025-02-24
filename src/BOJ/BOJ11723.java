package BOJ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 집합
public class BOJ11723 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("/Users/juice-in./Desktop/office-algorithm-folder/src/foolsCap.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> hs = new HashSet<>();

        boolean flag;
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch (order) {
                case "add" :
                    hs.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove" :
                    hs.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check" :
                    flag = hs.contains(Integer.parseInt(st.nextToken()));
                    if (flag)
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;
                case "toggle" :
                    int x = Integer.parseInt(st.nextToken());
                    flag = hs.contains(x);
                    if (flag)
                        hs.remove(x);
                    else
                        hs.add(x);
                    break;
                case "empty" :
                    hs.clear();
                    break;
                default :
                    hs.clear();
                    for (int j = 1; j <= 20; j++)
                        hs.add(j);
                    break;
            }
        }
        System.out.println(sb);
    }
}
