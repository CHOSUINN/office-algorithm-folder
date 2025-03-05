package LiveClass.심화.조합;

import java.util.ArrayList;
import java.util.List;

public class 조합04_중복조합 {

    static String[] 재료;
    static int n, r;

//    static List<String[]> result;
    static List<List<String>> result;

    public static void main(String[] args) {
        n = 4;
        r = 2;
        재료 = new String[]{"상추", "패티", "토마토", "치즈"};

        result = new ArrayList<>();

        combcomb(0, new ArrayList<>());
        for (List<String> temp : result)
            System.out.println(temp);
    }

    // current : 임시 리스트 / 배열로 처리, 등등 인덱스 필요할수도 있음
    public static void combcomb (int start, List<String> current) {

        // 종료조건
        if (current.size() == r) {
//            System.out.println(current);

//            List<String> temp = new ArrayList<>();
//            for (String str : current)
//                temp.add(str);
//            result.add(temp);

            result.add(new ArrayList<>(current));
            return;
        }

        // 재귀조건
        for (int i = start; i < n; i++) {
            current.add(재료[i]);  // 재료 넣기
            combcomb(i, current);  // 중복허용이니 i를 다시 고려야만 한다
            current.remove(current.size() - 1); // 재료 빼기(백트래킹)
        }

    }

}
