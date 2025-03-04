package LiveClass.기초.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackCalculator {
    public static void main(String[] args) {

        // 원래 같았으면 입력을 받았을거다.
        String infix = "(6+5*(2-8)/2";

        // 연산자 우선 순위
        // ( : 겉바속촉
        // +, - : 동급 1
        // *. / : 동급 2

        Map<Character, Integer> priority = new HashMap<>();
        priority.put('(', 0);
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);

        StringBuilder postFix = new StringBuilder();

        // 연산자를 담는 스택
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            // '('
            if (infix.charAt(i) == '(') {
                // 우선순위 겉바! 그냥 냅다 추가
                op.push(infix.charAt(i));
            }
            // ')'
            else if (infix.charAt(i) == ')') {
                // 여는 괄호를 만날때까지 꺼내고, 버린다.
                while (op.peek() != '(') {
                    postFix.append(op.pop());
                }
                op.pop(); // top이 가리키는 여는 소괄호 버리기
            }
            // 피연산자
            else if (infix.charAt(i) >= '0' && infix.charAt(i) <= '9') {
                postFix.append(infix.charAt(i));
            }
            // 연산자
            else {
                if (op.isEmpty()) {
                    op.push(infix.charAt(i));
                } else {

                    while (priority.get(op.peek()) >= priority.get(infix.charAt(i)) && !op.isEmpty()) {
                        postFix.append(op.pop());
                    }
                    op.push(infix.charAt(i));
                }
            }
            System.out.println(postFix);

        }


    }
}
