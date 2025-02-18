package SWEA;// 쇠막대기 자르기

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Staaaack<E> {

    List<E> arr = new ArrayList<>();

    public Staaaack() {
    }

    public void push(E a) {
        arr.add(a);
    }

    public E pop() {
        return arr.remove(arr.size() - 1);
    }


    public E peek() {
        return arr.get(arr.size() - 1);
    }

    public boolean isEmpty() {
        return arr.isEmpty();
    }

    public int size() {
        return arr.size();
    }

}

// 쇠막대기 자르기
public class SWEA5432 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < tc; t++) {

            Staaaack<Character> stack = new Staaaack<>();
            char[] arr = sc.nextLine().toCharArray();

            int answer = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '(') {
                    stack.push(arr[i]);
                } else if (arr[i - 1] != '(' && arr[i] == ')') {
                    stack.pop();
                    answer += 1;
                } else {
                    stack.pop();
                    answer += stack.size();
                }
            }

            System.out.printf("#%d %d\n", t + 1, answer);

        }

    }
}
