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

                int lt = 0;
                int rt = arr[i].length - 1;
                int leftStart;
                int rightStart;
                while (lt < rt) {

                    if (arr[i][lt] == arr[i][rt]) {
                        leftStart = lt;
                        rightStart = rt;
                        int cnt = 0;
                        boolean flag = true;
                        while (leftStart <= rightStart) {
                            if (arr[i][leftStart] != arr[i][rightStart]) {
                                flag = false;
                                break;
                            }
                            leftStart++;
                            rightStart--;
                        }
                        if (flag)
                            answer = findMax(answer, cnt);
                    }

                    rt--;

                }

            }

//            for (char[] chars : arr) {
//                for (char aChar : chars) {
//                    System.out.print(aChar + " ");
//                }
//                System.out.println();
//            }


            System.out.printf("#%d %d\n", t + 1, answer);
        }

    }

    private static int findMax(int a, int b) {
        return ((a > b) ? a : b);
    }
}
