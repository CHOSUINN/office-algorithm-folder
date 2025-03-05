import java.util.ArrayList;
import java.util.List;

public class Combination_ArrayList {

    static String[] arr;
    static int n, r;
    static List<List<String>> result;
    
    // arr배열에서 r로 지정된 숫자만큼의 조합 만들기
    public static void main(String[] args) {
        n = 4;
        r = 2;
        arr = new String[]{"상추", "패티", "토마토", "치즈"};

        result = new ArrayList<>();
        comb (0, new ArrayList<>());
        for (List<String> temp : result) {
            System.out.println(temp);
        }

    }

    /**
     * 조합 중복 가능
     */
    private static void comb(int arrIdx, List<String> sel) {
        if (sel.size() == r) {
            result.add(new ArrayList<>(sel));
            return;
        }

        for (int i = arrIdx; i < n; i++) {
            sel.add(arr[i]);
            comb(i, sel);
            sel.remove(sel.size() - 1);
        }

    }

    /**
     * 조합 중복 불가능
     */
//    private static void comb(int arrIdx, List<String> sel) {
//        // 종료조건
//        if (sel.size() == r) {
//            result.add(new ArrayList<>(sel));
//            return;
//        }
//
//
//        // 재귀 조건
//        for (int i = arrIdx; i < n; i++) {
//            sel.add(arr[i]);
//            comb(i + 1, sel);
//            sel.remove(sel.size() - 1);
//        }
//    }
}
