package LiveClass.tree;

import java.util.Arrays;
import java.util.Scanner;

public class 트리연습문제 {

    static int v;
    static int[][] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(input);

        v = Integer.parseInt(sc.nextLine());
        tree = new int[v + 1][3]; //[0] 왼쪽 자식, [1] 오른쪽 자식, [2] 부모
        String[] inputs = sc.nextLine().split(" ");
        for (int i = 0; i < inputs.length; i+=2) {
            int parentNode = Integer.parseInt(inputs[i]);
            int childNode = Integer.parseInt(inputs[i + 1]);


            if (tree[parentNode][0] == 0) {
                tree[parentNode][0] = childNode;
            } else {
                tree[parentNode][1] = childNode;
            }

            tree[childNode][2] = parentNode;
        }

        for (int i = 0; i < v + 1; i++)
            System.out.println(i + ": " + Arrays.toString(tree[i]));

        preOrder(1);


    }

    static void preOrder(int val) {
        System.out.print(val + " ");
        if (tree[val][0] == 0) return;
        preOrder(tree[val][0]);
        if (tree[val][1] == 0) return;
        preOrder(tree[val][1]);
    }

    static String input = "13\n"
            + "1 2 1 3 2 4 3 5 3 6 4 7 5 8 5 9 6 10 6 11 7 12 11 13";
}
