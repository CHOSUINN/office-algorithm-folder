package LiveClass.심화.비트연산자_부분집합;

import java.util.Arrays;

public class 부분집합01_반복문 {
    static String[] 재료 = {"단무지", "햄", "오이", "계란"};
    static int n = 4;
    // 해당 재료를 사용했는지 유무 확인 boolean[] 사용을 하지만 여기서는 int[]를 써보겠다..
    static int[] sel = new int[n]; // 0, 0, 0, 0 각 재료별로 선택됐을때를 표시.
    
    public static void main(String[] args) {
        // 반복문 : 재료의 개수만큼 사용해야함.
        // 단무지를 위한 for문
        for (int i = 0; i <= 1; i++) {
            sel[0] = i;
            // 햄을 위한 for문
            for (int j = 0; j <= 1; j++) {
                sel[1] = j;
                // 오이를 위한 for문
                for (int k = 0; k <= 1; k++) {
                    sel[2] = k;
                    // 계란을 위한 for문
                    for (int l = 0; l <= 1; l++) {
                        sel[3] = l;
                        System.out.println(Arrays.toString(sel));
                    }
                }
            }
        }
    }
}
