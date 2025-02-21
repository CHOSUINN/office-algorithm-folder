import java.util.*;

// 케빈 베이컨의 6단계 법칙
public class BOJ1389 {

    static List<int[]> relationShip;
    static boolean[] visited;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        relationShip = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            relationShip.add(new int[n]);
        }
        for (int i = 1; i <= m; i++) {
            String[] inputAB = sc.nextLine().split(" ");
            int a = Integer.parseInt(inputAB[0]);
            int b = Integer.parseInt(inputAB[1]);

            relationShip.get(a)[b] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    System.out.print(relationShip.get(i)[j]);
                }
                System.out.println();
            }
        }


//        int minRel = Integer.MAX_VALUE;
//        // 최소관계를 가진 사람
//        int answer = -1;
//        for (int i = 1; i <= n; i++) {
//            cnt = cntRelSum(relationShip.get(i));
//            if (cnt < minRel) {
//                minRel = cnt;
//                answer = i;
//            }
//        }


    }

    
//    // 관계의 수
//    private static int cntRelSum(int[] person) {
//        Queue<Integer> q = new LinkedList<>();
//        int total = 0;
//        for (int i = 0; i < person.length; i++) {
//        }
//
//
//    }



}
