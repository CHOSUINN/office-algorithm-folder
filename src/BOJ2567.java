import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이 - 2
public class BOJ2567 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[][] paper = new int[100][100];
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int r = b; r < b + 10; r++) {
                for (int c = a; c < a + 10; c++) {
                    paper[r][c] = 1;
                }
            }

        }

        // 둘레 길이 세기


//        for (int i = 0; i < 100; i++) {
//            for (int j = 0; j < 100; j++) {
//                System.out.print(paper[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
