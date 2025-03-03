import java.util.*;

// 보물상자 비밀번호
public class SOL_Suee97 {
    public static void main(String[] args) {

        Deque<Integer> dq = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        StringBuffer ans = new StringBuffer();
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            char[] input = sc.next().toCharArray();
            char[] arr = new char[n * 2];

            for (int i = 0; i < n * 2; i++) {
                arr[i] = input[i % n];
            }

            List<Integer> list = new ArrayList<>();
            for (int move = 0; move < n; move++) {
                for (int op = move; op < n + move; op += n / 4) {
                    StringBuffer sb = new StringBuffer();
                    for (int i = op; i < op + n / 4; i++) {
                        sb.append(arr[i]);
                    }
                    int to10 = Integer.parseInt(sb.toString(), 16);
                    list.add(to10);
                }
            }
            List<Integer> newList = list.stream().distinct().sorted((a, b) -> b - a).limit(k)
                    .toList();
            ans.append('#');
            ans.append(tc);
            ans.append(' ');
            ans.append(newList.get(newList.size() - 1));
            ans.append('\n');
        }
        System.out.println(ans);
    }
}