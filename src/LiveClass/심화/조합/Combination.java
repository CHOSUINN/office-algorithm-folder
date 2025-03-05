package LiveClass.심화.조합;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// 순열 연습

/**
 * 조합 만들어보기
 */
public class Combination {

    static String[] arr;
    static String[] sel;
    static int n, r;

    static List<List<String>> result;

    public static void main(String[] args) throws IOException {
        n = 4;
        r = 2;
        arr = new String[]{"상추", "패티", "토마토", "치즈"};
        sel = new String[r];

        // 중복없는 순열
//        comb(0, 0);


        result = new ArrayList<>();
        //중복있는 순열
        comb(0, new ArrayList<>());
        for (List<String> temp : result) {
            System.out.println(temp);
        }
    }


    /**
     * 중복이 되는 조합
     */
    private static void comb(int startIdx, List<String> sel) {
        //종료조건
        if (sel.size() == r) {
            result.add(new ArrayList<>(sel));
            return;
        }

        //재귀 조건
        for (int i = startIdx; i < n; i++) {
            sel.add(arr[i]);
            comb(i, sel);
            sel.remove(sel.size() - 1);
        }


    }

    /**
     * 중복이 없는 조합
     */
//    private static void comb(int selIndex, int arrIndex) {
//        System.out.println("selIndex: " + selIndex + " " + "arrIndex: " +  arrIndex);
//        if (selIndex == r) {
//            System.out.println(Arrays.toString(sel));
//            return;
//        }
//
//        if (arrIndex == n) {
//            return;
//        }
//
//        sel[selIndex] = arr[arrIndex];
//        comb(selIndex + 1, arrIndex + 1);
//
//        comb(selIndex, arrIndex + 1);
//
//
//    }
}
