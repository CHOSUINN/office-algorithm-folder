package SWEA;

import java.util.Scanner;
import java.util.Stack;

// 괄호짝짓기
public class SWEA1218 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stack<Character> stack = new Stack<>();

        for (int t = 0; t < 10; t++) {

            int n = Integer.parseInt(sc.nextLine());
            char[] arr = sc.nextLine().toCharArray();

            String answer = "";

            boolean flag = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == ('(') || arr[i] == ('[') || arr[i] == ('{') || arr[i] == ('<')) {
                    stack.push(arr[i]);
                } else if ((arr[i] == (')') && stack.peek() != '(')
                        || (arr[i] == (']') && (stack.peek() != ('[')))
                        || (arr[i] == ('}') && (stack.peek() != ('{')))
                        || (arr[i] == ('>') && (stack.peek() != ('<')))) {
                    flag = true;
                    break;
                } else {
                    stack.pop();
                }
            }

            if (flag)
                answer += "0";
            else
                answer += "1";

            System.out.printf("#%d %s\n", t + 1, answer);
        }

    }
}
