package LiveClass.심화.순열;

import java.util.Arrays;

public class 순열04_비트마스킹 {
    static int[] nums;
    static int n;
    static int[] result;  // 결과배열

    public static void main(String[] args) {
        nums = new int[]{0, 1, 2};
        n = nums.length;

        result = new int[n];
        perm(0, 0);
    }

    // idx : 현재 위치 판단
    static void perm(int idx, int visited) {
        // 기저조건
        //if (visited == (1<<n) - 1)  // 아래 조건문과 같다.
        if (idx == n) {
            System.out.println(Arrays.toString(result));
            return;
        }

        //재귀부분
        for (int i = 0; i < n; i++) {
            //사용했니?
            if ((visited & (1 << i)) != 0) {
                continue;
            }
            result[idx] = nums[i];
            perm(idx + 1, visited | (1 << i));
        }
    }
}
