package LiveClass.심화.조합;

import java.util.Arrays;

public class 조합01_재귀함수 {

    static String[] 재료 = {"상추", "패티", "토마토", "치즈"};
    static String[] sel;
    static int n, r;


    public static void main(String[] args) {
        n = 4;
        r = 2;
        재료 = new String[]{"상추", "패티", "토마토", "치즈"};
        sel = new String[r];

        comb(0, 0);
    }


    // idx: 내가 이번에 고려할 재료들의 인덱스
    // sidx : 뽑은 재료의 인덱스
    public static void comb (int idx, int sidx) {

        // 종료조건
        if (sidx == r) {
            // 재료선정 완료
            System.out.println(Arrays.toString(sel));
            return;
        }

        if (idx == n) {
            // 더이상 고려할 재료가 없어
            return;
        }

        // 재귀조건
        sel[sidx] = 재료[idx];
        comb(idx + 1, sidx + 1); // 뽑


        comb(idx + 1, sidx);//안뽑
        
        
    }
}
