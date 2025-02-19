package SWEA;

import java.util.Scanner;
import java.util.Stack;

// 계산기 1
public class SWEA1222 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < 10; t++) {
            char[] input = sc.nextLine().toCharArray();

            sb.append(input[0]);
            for (int i = 1; i < input.length; i++) {
                if (input[i] == '+')
                    stack.push(input[i]);
                else
                    sb.append(input[i]).append(stack.pop());
            }

            int answer = 0;
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '+')
                    while (!stack.isEmpty())
                        answer += (stack.pop() - '0');
                else
                    stack.push(sb.charAt(i));
            }

            System.out.printf("#%d %d\n", t + 1, answer);
            sb.setLength(0);

        }
    }
}
