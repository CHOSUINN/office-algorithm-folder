package SecondTest;

import java.util.Scanner;

// 의석이의 세로로 말해요
public class Test1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc = Integer.parseInt(sc.nextLine());
        char[][] answer;
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < tc; t++) {
            answer = new char[15][15];
            sb.setLength(0);

            int charMaxLength = 0;
            for (int i = 0; i < 5; i++) {
                char[] arr = sc.nextLine().toCharArray();
                charMaxLength = Math.max(arr.length, charMaxLength);
                for (int j = 0; j < arr.length; j++) {
                    answer[i][j] = arr[j];
                }
            }

            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    if (answer[j][i] == '\0') continue;
                    sb.append(answer[j][i]);
                }
            }

            //테스트 출력
//            for (char[] chars : answer) {
//                for (char aChar : chars) {
//                    System.out.print(aChar + " ");
//                }
//                System.out.println();
//            }

            System.out.printf("#%d %s\n", t + 1, sb);


        }

    }
}
