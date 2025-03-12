package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 재귀는 "믿음"이다.
 * 재귀는 쉬울라고 하는것이다. 성능적으로는 좋은건 물음표?
 * 재귀는 편할라고 쓰는것이다. 스택을 써봐라. 쉬운거 느껴질거다.
 * 스택 풀이, n으로 돌면서 같은 색인지 확인. 아니면 스택에 4개씩 넣기.
 */
// 색종이 만들기
public class BOJ2630 {

    final static int COLOR_BLUE = 1;
    final static int COLOR_WHITE = 0;

    static int blue;
    static int white;
    static int[][] rectangle;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        rectangle = new int[n][n];
        for (int i = 0; i < n; i++) { st = new StringTokenizer(br.readLine(), " "); for (int j = 0; j < n; j++) rectangle[i][j] = Integer.parseInt(st.nextToken()); }

        blue = 0;
        white = 0;
        ftPaper(n, 0, 0);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void ftPaper(int paperSize, int y, int x) {

        int temp = rectangle[y][x];
        for (int i = y; i < paperSize + y; i++) {
            for (int j = x; j < paperSize + x; j++) {
                if (temp != rectangle[i][j]) {

                    ftPaper(paperSize / 2, y, x);

                    ftPaper(paperSize / 2, y, x + (paperSize / 2));

                    ftPaper(paperSize / 2, y + (paperSize / 2), x);

                    ftPaper(paperSize / 2, y + (paperSize / 2), x + (paperSize / 2));

                    return;
                }
            }
        }

        if (temp == COLOR_BLUE)
            blue++;
        else
            white++;
    }
}
