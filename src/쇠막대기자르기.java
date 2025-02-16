import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Character> stack = new Stack<>();
        int tc = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < tc; t++) {
            int answer = 0;
            char[] input = sc.nextLine().toCharArray();

            for (int i = 0; i < input.length; i++) {
                if (input[i] == '(')
                    stack.push(input[i]);
                else if (input[i] == ')' && input[i - 1] == ')') {
                    stack.pop();
                    answer++;
                } else if (input[i] == ')') {
                    stack.pop();
                    answer += stack.size();
                }
            }
            System.out.printf("#%d %d", t + 1, answer);
        }
    }
}
