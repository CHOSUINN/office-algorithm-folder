//import java.util.Scanner;
//
//// 나는야 포켓몬 마스터 이다솜
//public class BOJ1260 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        StringBuilder sb = new StringBuilder();
//
//        String[] inputs = sc.nextLine().split(" ");
//        int n = Integer.parseInt(inputs[0]);
//        int m = Integer.parseInt(inputs[1]);
//
//        String[] arr = new String[n + 1];
//
//        for (int i = 1; i <= n; i++)
//            arr[i] = sc.nextLine();
//
//        for (int i = 0; i < m; i++) {
//            String quiz = sc.nextLine();
//            char[] temp = quiz.toCharArray();
//            if (temp[0] >= '0' && temp[0] <= '9') {
//                int quig = Integer.parseInt(quiz);
//                System.out.println(arr[quig]);
//            }
//            else {
//                for (int j = 1; j <= n; j++) {
//                    if (arr[j].equals(quiz)) {
//                        System.out.println(j);
//                        break;
//                    }
//                }
//            }
//
//        }
//
//    }
//}
