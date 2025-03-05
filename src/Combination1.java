import java.util.Arrays;

public class Combination1 {

    static String[] arr;
    static String[] sel;
    static int n, r;

    public static void main(String[] args) {
        n = 4;
        r = 2;
        arr = new String[]{"상추", "패티", "토마토", "치즈"};
        sel = new String[r];

        comb(0, 0);
    }

    /**
     * 조합 중복 고려X
     */
    private static void comb(int selIdx, int arrIdx) {
        
        // 종료 조건
        if(selIdx == r) {
            System.out.println(Arrays.toString(sel));
            return;
        }
        if (arrIdx == n)
            return;
        
        
        
        // 재귀 조건
        sel[selIdx] = arr[arrIdx];
        
        // 하나 설정한 상태에서 다음 상태로 넘어가는 재귀, 본인은 제외해야하기 때문에 arrIdx + 1을 해서 중복을 피해줘야한다.
        comb(selIdx + 1, arrIdx + 1);

        // 본인이 변해야 하는 재귀
        comb(selIdx, arrIdx + 1);
    }


    /**
     *
     * 조합 중복 고려
     */
//    private static void comb(int selIdx, int arrIdx) {
//
//        // 종료조건
//        if (selIdx == r) {
//            System.out.println(Arrays.toString(sel));
//            return;
//        }
//
//        if (arrIdx == n) {
//            return;
//        }
//
//
//        //재귀조건
//        sel[selIdx] = arr[arrIdx];
//        comb(selIdx + 1, arrIdx);
//
//        comb(selIdx, arrIdx + 1);
//
//    }

}
