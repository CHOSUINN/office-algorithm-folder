import java.util.*;

public class IM {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t=1; t<= T; t++) {
            int N = sc.nextInt();

            int[][] arr = new int[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int longest = Integer.MIN_VALUE;

            for(int i=0; i<N; i++) {
                int cnt = 1;
                for(int j=0; j<N; j++) {

                    int nextValue = 501;

                    int x = i;
                    int y = j;
                    boolean flag = false;
                    while(true){
                        for (int dir = 0; dir < 4; dir++) {
                            int temp = nextValue;
                            int nx = i + dx[dir];
                            int ny = j + dy[dir];


                            if(nx >= 0 && nx<N && ny>=0 && ny < N) {
                                if(nextValue > arr[nx][ny]) {
                                    nextValue = arr[nx][ny];
                                    x = nx;
                                    y = ny;
                                    System.out.println(x + " " + y);
                                    cnt ++;
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag) break;
                        }
                        if (flag) break;
                    }


                }
                longest = Math.max(cnt, longest);
            }

            System.out.println("#" + t + " " +longest);
        }

    }
}


