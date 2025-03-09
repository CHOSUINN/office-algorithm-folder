import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// [모의 SW 역량테스트] 요리사

/**
 * 설계
 * - 입력값을 2차원 배열에 저장한다.
 * - 입력값을 행 기준으로 모든 조합을 찾아서 result 동적배열에 저장한다
 *   단, 행과 열의 값이 같은 건, 조합하면 안되기 때문에 제외시킨다.
 * - result에 모인 조합들로 조합을 하나씩 찾으면서, answer에 차의 합을 계산해서 최소가 되는 값을 저장한다.
 */
public class SWEA4012 {

    static int[][] map;
    static int answer;
    static int n;
    static List<List<Integer>> result;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/foolsCap.txt"));
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
            findComb(0, new ArrayList<>());

            //출력
            for (List<Integer> temp : result) {
                System.out.println(temp);
            }
            
            // 모든 조합에 대한 차 계산
            // 조합을 하나씩 뽑아서 그 계산을 sel에 하나씩 계산해 넣는다.
            int[] sel = new int[2];
            findAnswer(sel, 0, 0);

//            sb.append("#").append(t + 1).append(" ").append(answer);
//            System.out.println(sb);
//            sb.setLength(0);
        }
    }

    // 두 조합을 뽑아서 그 차를 계산.
    private static void findAnswer(int[] sel, int selIdx, int resultIdx) {
        if (selIdx == 2) {
            int a = sel[0];
            int b = sel[1];
            int sumUp = Math.abs(a - b);
            answer = Math.min(answer, sumUp);
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
            findComb(i + 1, sel);
            sel.remove(sel.size() - 1);
        }
    }
}
