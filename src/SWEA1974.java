import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 스도쿠 검증
public class SWEA1974 {

    static final int SUDOKU_NUM = 9;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/foolsCap.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {

            int[][] sudoku = new int[SUDOKU_NUM][SUDOKU_NUM];

            for (int i = 0; i < SUDOKU_NUM; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < SUDOKU_NUM; j++) {
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean flag = checkSudoku(sudoku);

            sb.append("#").append(t + 1).append(" ");
            if (flag)
                sb.append(1).append("\n");
            else
                sb.append(0).append("\n");

            System.out.print(sb);
            sb.setLength(0);
        }
    }

    private static boolean checkSudoku(int[][] sudoku) {

        for (int i = 0; i < SUDOKU_NUM; i++) {
            HashSet<Integer> hsRow = new HashSet<>();
            HashSet<Integer> hsCol = new HashSet<>();
            for (int j = 0; j < SUDOKU_NUM; j++) {
                if (!hsRow.add(sudoku[i][j]))
                    return false;

                if (!hsCol.add(sudoku[j][i]))
                    return false;
            }
        }

        for (int i = 0; i < SUDOKU_NUM; i += 3) {
            for (int j = 0; j < SUDOKU_NUM; j += 3) {
                if (!checkBoxSudoku(i, j, sudoku))
                    return false;
            }
        }
        return true;
    }

    private static boolean checkBoxSudoku(int i, int j, int[][] sudoku) {
        HashSet<Integer> hs = new HashSet<>();
        for (int x = i; x < i + 3; x++) {
            for (int y = j; y < j + 3; y++) {
                if (!hs.add(sudoku[x][y]))
                    return false;
            }
        }
        return true;
    }
}
