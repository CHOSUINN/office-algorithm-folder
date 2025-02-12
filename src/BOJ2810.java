import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// 백준 2810 컵홀더
public class BOJ2810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        char[] inputs = input.toCharArray();

        List<Character> arr = new ArrayList<>();
        arr.add('*');
        for (int i = 0; i < n; i++) {
            if (inputs[i] == 'S') {
                arr.add('S');
                arr.add('*');
            } else if (inputs[i] == 'L') {
                arr.add('L');
                i++;
                arr.add('L');
                arr.add('*');
            }
        }

        int answer = 0;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) != '*' && arr.get(i) != '0') {
                if (arr.get(i - 1) == '*') {
                    answer++;
                    arr.set(i - 1, '0');
                    arr.set(i, '0');
                } else if (i + 1 < arr.size() && arr.get(i + 1) == '*') {
                    answer++;
                    arr.set(i + 1, '0');
                    arr.set(i, '0');
                }
            }
        }

        System.out.println(answer);

    }
}
