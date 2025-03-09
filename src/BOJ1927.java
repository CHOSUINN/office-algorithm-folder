import java.io.*;
import java.util.StringTokenizer;

// 최소 힙
public class BOJ1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());

            switch (num) {
                case 0:
                    arrPoll();
                    break;
                default:
                    arrPush(num);
                    break;
            }


        }

    }

    // 값 추가
    private static void arrPush(int num) {
    }

    // 최소힙 추출, 및 출력
    private static void arrPoll() {
    }
}

/**
 * 우선순위 큐 자료구조 사용 풀이
 */
//public class BOJ1927 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        int n = Integer.parseInt(st.nextToken());
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int num = Integer.parseInt(st.nextToken());
//
//            switch (num) {
//                case 0 :
//                    if (pq.isEmpty()) {
//                        bw.write("0\n");
//                    } else {
//                        bw.write(pq.poll() + "\n");
//                    }
//                    break;
//                default :
//                    pq.offer(num);
//                    break;
//            }
//        }
//        bw.flush();
//    }
//}
