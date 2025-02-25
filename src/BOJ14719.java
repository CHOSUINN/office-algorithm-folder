import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

// 빗물

/**
 * 스택으로 풀이..?
 */
public class BOJ14719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        Stack<Integer> stack = new Stack<>();
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[w];

        st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < w; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int answer = 0;
        int index = 0;
        while (index < w) {
            if (arr[index] != 0)
                break;
            index++;
        }

        int maxHeight = arr[index];
        for (int i = index + 1; i < w; i++) {
            if (maxHeight <= arr[i]) {
                while(!stack.isEmpty()) {
                    answer += maxHeight - stack.pop();
                }
            } else
                stack.push(arr[i]);
        }

        // 스택의 값이 0이 아닌 경우까지 뽑아냄
        while (stack.peek() == 0)
            stack.pop();

        maxHeight = stack.pop();
        while (!stack.isEmpty()) {

        }
        System.out.println(answer);
    }
}



/**
 * 투 포인터 풀이
 */
//public class BOJ14719 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        StringTokenizer st = new StringTokenizer(sc.nextLine());
//        int h = Integer.parseInt(st.nextToken());
//        int w = Integer.parseInt(st.nextToken());
//        int[] arr = new int[w];
//
//        st = new StringTokenizer(sc.nextLine());
//        for (int i = 0; i < w; i++)
//            arr[i] = Integer.parseInt(st.nextToken());
//
//        int answer = 0;
//        int lt = 0;
//        int rt = w - 1;
//        int leftMax = arr[lt];
//        int rightMax = arr[rt];
//        while (lt < rt) {
//            if (leftMax < arr[lt])
//                leftMax = arr[lt];
//            if (rightMax < arr[rt])
//                rightMax = arr[rt];
//
//            if (leftMax <= rightMax) {
//                answer += leftMax - arr[lt];
//                lt++;
//            } else {
//                answer += rightMax - arr[rt];
//                rt--;
//            }
//
//        }
//        System.out.println(answer);
//    }
//}
