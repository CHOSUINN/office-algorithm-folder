package SecondTest;

import java.util.Scanner;

// 보물상자 비밀번호

/**
 * n을 4로 나눠서 몇자리수 16진수인지 확인하고,
 * 이를 10진수로 변환해서 arr[여기에] 넣어줌.
 * 반복문으로 배열을 돌면서 k번째 숫자를 출력.
 *
 */
public class Test3 {

    static char[] cs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = Integer.parseInt(sc.nextLine());
//        int[] arr = new int[2147483647];


        for (int t = 0; t < tc; t++) {

            String[] inputs = sc.nextLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);

            int jarisu = n / 4;
            char[] arr = new char[n * jarisu];


            cs = sc.nextLine().toCharArray();


            for (int i = 0; i < jarisu; i++) {
                turnToDigit(jarisu, cs[i + (i * jarisu)]);
            }

            //k번째 수 찾기
            int index = 0;
            int cnt = 0;
            int answer = 0;
            while (index < arr.length) {
                if (arr[index] != 0) {
                    cnt++;
                }
                if (cnt == k) {
                    answer = arr[index];
                    break;
                }
                index++;
            }

        }



    }

    // 16진수 -> 10진수
    private static int turnToDigit(int jarisu, int index) {
        int num = 1;
        for (int i = 0; i < jarisu; i++) {
            num = num * 16 + cs[index + i];
        }
        return num;
    }
}


