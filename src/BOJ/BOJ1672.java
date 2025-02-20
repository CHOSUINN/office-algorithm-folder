package BOJ;

import java.util.Scanner;
import java.util.Stack;

// DNA 해독
public class BOJ1672 {

    static char[][] table = {
            {'A', 'C', 'A', 'G'},
            {'C', 'G', 'T', 'A'},
            {'A', 'T', 'C', 'G'},
            {'G', 'A', 'G', 'T'}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        char[] inputs = sc.nextLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < inputs.length; i++)
            stack.push(inputs[i]);

        while (stack.size() >= 2) {
            int a = changeCharToInteger(stack.pop());
            int b = changeCharToInteger(stack.pop());

            char c = table[a][b];
            stack.push(c);
        }

        System.out.println(stack.pop());

    }

    // 알파벳에 맞게 인덱스로 변경
    private static int changeCharToInteger(char x) {
        if (x == 'A')
            return 0;
        else if (x == 'G')
            return 1;
        else if (x == 'C')
            return 2;
        else
            return 3;
    }
}
