import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 경사로
public class BOJ14890 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        // 가로 경사로
        for (int i = 0; i < n; i++) {
            int curHeight = map[i][0];
            for (int j = 1; j < n; j++) {
                if (curHeight == map[i][j])
                    continue;
                else if (curHeight > map[i][j]) {

                    if (curHeight - map[i][j] != 1)
                        break;
                    // 현 위치 포함 뒤로 l - 1만큼 평평한지 확인
                    boolean flag = true;
                    for (int dis = 1; dis <= l; dis++) {
                        if (j - dis < 0) {
                            flag = false;
                            break;
                        }

                        if (curHeight != map[i][j - dis]) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) break;
                    curHeight = map[i][j];
                } else {

                    if (curHeight - map[i][j] != 1)
                        break;
                    boolean flag = true;
                    for (int dis = 1; dis < l; dis++) {
                        if (j + dis > n - 1) {
                            flag = false;
                            break;
                        }

                        if (map[i][j] != map[i][j - dis]) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) break;
                    curHeight = map[i][j];
                }
            }
        }
        System.out.println(answer);
    }
}
