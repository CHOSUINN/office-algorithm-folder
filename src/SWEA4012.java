import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [모의 SW 역량테스트] 요리사
public class SWEA4012 {

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }







        }




    }
}
