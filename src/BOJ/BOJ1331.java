package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나이트 투어
// 나이트의 이동 범위인지 확인
// 시작 위치와 끝 위치가 같은지
// 한번도 방문하지 않은 위치인지
public class BOJ1331 {

    static final int CHESS_BOARD = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        boolean[][] board = new boolean[CHESS_BOARD][CHESS_BOARD];
        boolean flag = false;
        int[] startLocation = new int[2];
        int[] prevLocation = new int[]{0, 0};

        for (int i = 0; i < CHESS_BOARD * CHESS_BOARD; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            int c = Integer.parseInt(String.valueOf((temp.charAt(0)) - 65));
            int r = Integer.parseInt(String.valueOf((temp.charAt(1)))) - 1;

            if (board[r][c]) {
                System.out.println("Invalid");
                return;
            }

            board[r][c] = true;

            // 나이트의 첫번째 위치일 경우
            if (!flag) {
                startLocation[0] = r;
                startLocation[1] = c;
                flag = true;
                prevLocation[0] = r;
                prevLocation[1] = c;
            } else {

                if (!((Math.abs(prevLocation[0] - r) == 2 && Math.abs(prevLocation[1] - c) == 1) ||
                        (Math.abs(prevLocation[0] - r) == 1 && Math.abs(prevLocation[1] - c) == 2))) {
                    System.out.println("Invalid");
                    return;
                }

                prevLocation[0] = r;
                prevLocation[1] = c;

            }

        }

        if (!( ((Math.abs(prevLocation[0] - startLocation[0]) == 1) && (Math.abs(prevLocation[1] - startLocation[1]) == 2)) ||
        (Math.abs(prevLocation[0] - startLocation[0]) == 2 && (Math.abs(prevLocation[1] - startLocation[1]) == 1)))) {
            System.out.println("Invalid");
            return;
        }

        System.out.println("Valid");

    }

}
