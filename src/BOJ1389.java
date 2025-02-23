//import java.util.*;
//
//// 케빈 베이컨의 6단계 법칙
//public class BOJ1389 {
//
//    static int[][] relationShip;
//    static boolean[] visited;
//    static int cnt;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        String[] input = sc.nextLine().split(" ");
//        int n = Integer.parseInt(input[0]);
//        int m = Integer.parseInt(input[1]);
//
//        relationShip = new int[n + 1][n + 1];
//
//        for (int i = 0; i < n; i++)
//            relationShip.add(new ArrayList<>());
//
//        for (int i = 0; i < m; i++) {
//            String[] inputAB = sc.nextLine().split(" ");
//            int a = Integer.parseInt(inputAB[0]);
//            int b = Integer.parseInt(inputAB[1]);
//
//            relationShip[a][b] = new int[] {-1,1}
////            relationShip.get(a - 1).add(new int[]{b, 1});
////            relationShip.get(b - 1).add(new int[]{a, 1});
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < relationShip.get(i).size(); j++) {
//                System.out.println(i + "=" + Arrays.toString(relationShip.get(i).get(j)));
//            }
//        }
//
//        int minRelation = Integer.MAX_VALUE;
//        int minPerson = -1;
//        for (int i = 0; i < n; i++) {
//            cnt = cntRelationShip(i, n);
//            if (minRelation = > cnt) {
//                minRelation = cnt;
//                minPerson = i;
//            }
//        }
//
//        System.out.println(minPerson + 1);
//
//    }
//
//    private static int cntRelationShip(int personNum, int n) {
//        Queue<int[]> q = new LinkedList<>();
//        for (int i = 0; i < relationShip.get(i).size(); i++) {
//            q.offer(relationShip.get(personNum).get(i));
//        }
//        int len = q.size();
//
//        while (!q.isEmpty()) {
//
//        }
//
//        return  0;
//    }
//}