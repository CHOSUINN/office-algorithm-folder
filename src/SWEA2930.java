import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


// 힙
public class SWEA2930 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < tc; t++) {
            pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            sb.append("#").append(t + 1);

            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                String[] inputs = sc.nextLine().split(" ");
                if (Integer.parseInt(inputs[0]) == 1) {
                    // 자연수 x 삽입
                    pq.offer(Integer.parseInt(inputs[1]));
                } else {
                    // 최댓값 출력 후 해당 키값 삭제
                    if (!pq.isEmpty()) {
                        int a = pq.poll();
                        sb.append(" ").append(a);
                    } else
                        sb.append(" ").append(-1);
                }
            }

            System.out.println(sb);
            sb.setLength(0);
        }
    }

}
