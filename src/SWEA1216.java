import java.io.*;

// 회문2
public class SWEA1216 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 0; t < 10; t++) {

            int num = Integer.parseInt(br.readLine());
            char[][] arr = new char[100][100];
            int answer = 1;

            for (int i = 0; i < 100; i++) {
                arr[i] = br.readLine().toCharArray();

            }


            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    int lt = j;
                    int rt = j + 1;
                    int cnt = 2;

                    while (lt >= 0 && rt < 100) {
                        if (arr[lt] != arr[rt]) {
                            break;
                        }
                        cnt += 2;
                        lt--;
                        rt++;
                    }

                    answer = findMax(cnt, answer);

                }
                System.out.println(answer);
            }

//            for (char[] chars : arr) {
//                for (char aChar : chars) {
//                    System.out.print(aChar + " ");
//                }
//                System.out.println();
//            }




        }

    }

    private static int findMax(int a, int b) {
        return ((a > b) ? a : b);
    }
}
