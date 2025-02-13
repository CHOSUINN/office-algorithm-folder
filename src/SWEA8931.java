import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Staaaaack  <E> {

    List<E> arr = new ArrayList<>();

    public Staaaaack () {
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

// 제로
public class SWEA8931 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int t = 0; t < tc; t++) {
            Staaaack<Integer> stack = new Staaaack<>();
            int k = sc.nextInt();
            int cnt = 0;
            for (int i = 0; i < k; i++) {
                int num = sc.nextInt();
                if (num == 0) {
                    stack.pop();
                    cnt--;
                } else {
                    stack.push(num);
                    cnt++;
                }
            }
            int answer = 0;
            while (!stack.isEmpty()) {
                answer += stack.pop();
            }

            System.out.printf("#%d %d\n", t + 1, answer);
        }

    }

}
