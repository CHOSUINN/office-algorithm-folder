package SWTestA;

import java.util.Arrays;
import java.util.Scanner;


// 우준형
class KYJ
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for(int t = 1; t <= T; t++) {
            String[] input = sc.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int P = Integer.parseInt(input[1]);

            int[] A = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] B = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[][] arr = {A, B};

            int cnt = (int)Math.pow(2, N)-1;
            int max = 0;
            while(cnt > 0) {
                int sum = 0;
                String c = Integer.toBinaryString(cnt--);
                if(c.length() < N) {
                    int len = N - c.length();
                    for(int i = 0; i < len; i++) {
                        c = "0" + c;
                    }
                }
                for(int i = 0; i < N; i++) {
                    if(i != 0 && c.charAt(i-1) == c.charAt(i)) {
                        sum += arr[c.charAt(i) - '0'][i] - P;
                    } else {
                        sum += arr[c.charAt(i) - '0'][i];
                    }
                }
                if(sum > max) max = sum;
            }
            System.out.printf("#%d %d\n", t, max);
        }
    }
}