package BOJ;

import java.util.Scanner;

// 모음의 개수
public class BOJ10987 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] inputs = sc.nextLine().toCharArray();
        int answer = 0;

        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] == 'a'
                    || inputs[i] == 'e'
                    || inputs[i] == 'i'
                    || inputs[i] == 'o'
                    || inputs[i] == 'u') {
                answer++;
            }
        }

        System.out.println(answer);

    }
}
