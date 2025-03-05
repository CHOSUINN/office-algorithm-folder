package LiveClass.심화.조합;

import java.util.ArrayList;
import java.util.List;

public class 조합03_재귀함수_반복문 {

    static String[] 재료;
    static String[] sel;
    static int n, r;

    static List<String[]> result;

    public static void main(String[] args) {
        n = 4;
        r = 2;
        재료 = new String[]{"상추", "패티", "토마토", "치즈"};
        sel = new String[r];

        result = new ArrayList<>();
        comb(0, 0);

//        for (String[] arr : result)
//            System.out.println(Arrays.toString(arr));

    }

    // idx : 내가 고려할 재료들의 인덱스
    // sidx : 뽑은 재료의 인덱스
    public static void comb(int idx, int sidx) {

        if (sidx == r) {
//            System.out.println(Arrays.toString(sel));
            result.add(sel);
            return;
        }
        
        // 재귀조건
        // 범위를 정해놓고 호출 할것!
        for (int i = idx; i <= n - r + sidx; i++) {
            sel[sidx] = 재료[i];
            comb(i + 1, sidx + 1);
        }
    }

}
