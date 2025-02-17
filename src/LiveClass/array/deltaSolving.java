package LiveClass.array;

public class deltaSolving {
    
    // static을 통해 델타 선언을 많이 함!
    // But, 이번에는 main문에서 선언해서 푼다고 함.
    
    public static void main(String[] args) {
        // 상하좌우
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int[][] arr = new int[3][3];

        int n = arr.length;
        int r = 0;
        int c = 0;

        //dr, dc를 순회하기 위한 for문. 4방향을 보기 위함.
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];   // nr은 nextRow를 줄임
            int nc = c + dc[d];

            // nr, nc로 배열에 접근할 때, 배열 범위 밖으로 나가면 ArrayIndexOutOfBoundsException이 뜬다.
            // 2가지 방식으로 4방향 접근 제한을 할 수 있음
            // 1. 내 안에 들어오면 할래!
            // 2. 내 밖이야? 그럼 안해~

//            1. 내 안에 들어오면 할래!
//            if (r >= 0 && nr < n && nc >= && nc < n) {
//                System.out.println(arr[nr][nc]);
//            }

            // 2. 내 밖이야? 그럼 안해~
            // 이 방법을 선호하는 사람이 더 많았던거 같다고 하심.
            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
            System.out.println(arr[nr][nc]);



            //배열회전 로직// swea 배열 회전 문제
//            for (int i = 0; i < n; i++)
//                for (int j = 0; j < n; j++) {
//
//                    //90도 회전
//                    arr[i][j] = arr[n-1 -j][i]
//
//                    // 180도 회전
//                    arr[i][j] = arr[n-1-i][n-1-j]
//
//                    // 270도 회전
//                    arr[i][j] = arr[j][n-1-i]
//                }




        }




    }
}
