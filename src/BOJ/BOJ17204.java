package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 죽음의 게임
public class BOJ17204 {

    static int n;
    static int k;
    static HashMap<Integer, Integer> hm;
    static int answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        hm = new HashMap<>();
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int target = Integer.parseInt(st.nextToken());
            hm.put(i, target);
        }

        answer = 0;
        int cnt = 0;
        int nextNum = 0;
        boolean flag = false;
        while (cnt < n) {
            if (visited[nextNum]) {
                flag = true;
                break;
            }
            visited[nextNum] = true;
            int nextPerson = hm.get(nextNum);
            answer++;
            nextNum = nextPerson;
            if (nextPerson == k){
                flag = false;
                break;
            }

            cnt++;
        }

        sb.append((flag) ? -1 : answer);
        System.out.println(sb);

    }
}
