//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//// 햄스터
//public class SWEA8275 {
//
//    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/foolsCap.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        StringBuilder sb = new StringBuilder();
//
//        int tc = Integer.parseInt(st.nextToken());
//        for (int t = 0; t < tc; t++) {
//            sb.append("#").append(t + 1).append(" ");
//            st = new StringTokenizer(br.readLine(), " ");
//
//            int n = Integer.parseInt(st.nextToken());
//            int x = Integer.parseInt(st.nextToken());
//            int m = Integer.parseInt(st.nextToken());
//
//            int[] cage = new int[n + 1];
//            // 최대값 x로 전부 채워놓고, 우리 안에 기록들을 받으면서 만들수 없는 값이 나오면 바로 연산을 중지시킨다.
//            Arrays.fill(cage, x);
//
//            for (int i = 0; i < m; i++) {
//                st = new StringTokenizer(br.readLine(), " ");
//                int a = Integer.parseInt(st.nextToken());
//                int b = Integer.parseInt(st.nextToken());
//                int total = Integer.parseInt(st.nextToken());
//
//                int sum = 0;
//                for (int j = a; j <= b; j++) {
//                    sum += cage[j];
//                }
//                if (total > sum) {
//                    sb.append("-1");
//                    break;
//                }
//
//                for (int i = 0; i <= x; i++) {
//
//                }
//            }
//
//            System.out.println(sb);
//            sb.setLength(0);
//        }
//
//    }
//}
