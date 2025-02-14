package LiveClass;

public class snailCircle {

    // 달팽이 순회 문제
    // 델타 방식을 사용하면 더 쉬우나, 아래 코드는 규칙을 이용한 풀이이다
    public static void main(String[] args) {

        int n = 4;
        int[][] arr = new int[n][n];

        int k = n;       // k만큼 길이를 이동할거야!
        int dir = 1;     // 증감을 위한 변수 -> 1 혹은 -1
        int r = 0;       // row
        int c = -1;      // colum
        int num = 1;

        // 무한루프는 끝내는 조건을 반드시 넣어줘야 한다.(종료조건)
        while (true) {

            // 수평 -> 수직
            for (int i = 0; i < k; i++) {
                c += dir;
                arr[r][c] = num++;
            }
            k--;

            // 종료조건
            // num == n*n
            // k == 0
            // 종료조건이 여러가지가 될 수 있다. 
            // (r, c) == (중앙좌표) 일때

            if (k == 0) break;

            // 수직 -> 수평
            for (int i = 0; i < k; i++) {
                r += dir;
                arr[r][c] = num++;
            }
            dir = -dir;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();

        }

    }
}
