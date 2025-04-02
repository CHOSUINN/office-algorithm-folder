import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [S/W 문제해결 응용] 4일차 - 하나로
public class SWEA1251 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/foolsCap.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());

            long[] arrx = new long[n];
            long[] arry = new long[n];

            // x 죄표 받기
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++)
                arrx[i] = Long.parseLong(st.nextToken());

            // y 좌표 받기
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++)
                arry[i] = Long.parseLong(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            double e = Double.parseDouble(st.nextToken());

            //여기까지 입력값 받기//


            // 정점의 개수만큼 프림 알고리즘을 위한 차트 배열 만들기
            // 각각 부모, key값, 트리 소속인지 확인하는 배열
            int[] p = new int[n];
            long[] dist = new long[n];
            boolean[] visited = new boolean[n];

            // dist 아주 큰 값으로 초기화(int 최대값)
            for (int i = 0; i < n; i++) {
                dist[i] = Long.MAX_VALUE;
                p[i] = -1;
            }

            // 시작 정점 고르기.
            dist[0] = 0;
            long sum = 0;

            // 프림 알고리즘 차트배열을 돌면서 정점 뽑기
            for (int i = 0; i < n; i++) {
                // 가장 작은 값을 고름
                long min = Long.MAX_VALUE;
                int idx = -1;
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && dist[j] < min) {
                        min = dist[j];
                        idx = j;
                    }
                }

                // idx는 가장 작은 이번에 뽑은 정점이 된다.
                visited[idx] = true;
                sum += dist[idx];


                // 갱신
                for (int j = 0; j < n; j++) {
                    if (!visited[j]) {
                        long dx = arrx[idx] - arrx[j];
                        long dy = arry[idx] - arry[j];
                        long cost = (dx * dx + dy * dy);

                        if (cost < dist[j]) {
                            dist[j] = cost;
                        }
                    }
                }
            }

            double result = sum * e;

            sb.append("#").append(t + 1).append(" ").append(Math.round(result));
            System.out.println(sb);
            sb.setLength(0);

        }
    }
}
