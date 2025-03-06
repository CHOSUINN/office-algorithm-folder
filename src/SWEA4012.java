import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// [모의 SW 역량테스트] 요리사
public class SWEA4012 {

    static int[][] map;
    static int answer;
    static int n;
    static List<List<Integer>> result;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/foolsCap.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            result = new ArrayList<>();

            answer = Integer.MAX_VALUE;

            // 모든 조합 추출
            for (int i = 0; i < n; i++)
                findComb(i, new ArrayList<>());

            // 출력
//            for (List<Integer> temp : result) {
//                System.out.println(temp);
//            }
            
            // 모든 조합에 대한 차 계산
            int[] sel = new int[2];
            findAnswer(sel, 0, 0);

            sb.append("#").append(t + 1).append(" ").append(answer);
            System.out.println(sb);
            sb.setLength(0);
        }


    }

    private static void findAnswer(int[] sel, int selIdx, int resultIdx) {

        if (selIdx == 2) {
            int a = sel[0];
            int b = sel[1];
            int sumup = Math.abs(a - b);
            answer = Math.min(answer, sumup);
            return;
        }


        if (resultIdx == result.size()) return;

        List<Integer> temp = result.get(resultIdx);
        int sum1 = map[temp.get(0)][temp.get(1)] + map[temp.get(1)][temp.get(0)];
        sel[selIdx] = sum1;
        findAnswer(sel, selIdx + 1, resultIdx + 1);

        findAnswer(sel, selIdx, resultIdx + 1);


    }

    private static void findComb(int startIdx, List<Integer> sel) {

        if (sel.size() == 2) {
            result.add(new ArrayList<>(sel));
            return;
        }

        if (startIdx == n)
            return;

        for (int i = startIdx; i < n; i++) {
            sel.add(i);
            findComb(i, sel);
            sel.remove(sel.size() - 1);
        }
    }
}
