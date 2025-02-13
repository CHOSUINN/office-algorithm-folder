//import java.util.Scanner;
//import java.util.Stack;
//
//public class SWEA1218 {
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        Stack<String> stack = new Stack<>();
//
//        for (int t = 0; t < 10; t++) {
//
//            int n = Integer.parseInt(sc.nextLine());
//            String[] arr = new String[n];
//
//            for (int i = 0; i < n; i++) {
//                arr[i] = sc.next();
//            }
//            String answer = "";
//
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i].equals("(") || arr[i].equals("[") || arr[i].equals("{") || arr[i].equals("<")) {
//                    stack.push(arr[i]);
//                } else if (arr[i].equals("(") && stack.peek().)
//            }
//
//            for (char c : input) {
//                if (c == '(' || c == '[' || c == '{' || c == '<') {
//                    stack.push(c);
//                } else if (c == ')' && stack.peek() != '(') {
//                    break;
//                } else if (c == ']' && stack.peek() != '[') {
//                    break;
//                } else if (c == '}' && stack.peek() != '{') {
//                    break;
//                } else if (c == '<' && stack.peek() != '>') {
//                    break;
//                } else if (!(stack.isEmpty())) {
//                    stack.pop();
//                }
//            }
//
//            if (stack.isEmpty())
//                answer += "1";
//            else
//                answer += "0";
//
//            System.out.printf("#%d %s\n", t + 1, answer);
//        }
//
//    }
//}
