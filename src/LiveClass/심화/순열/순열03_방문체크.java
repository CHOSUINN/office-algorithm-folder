package LiveClass.심화.순열;

import java.util.Arrays;

public class 순열03_방문체크 {
    static int[] nums;
    static int n;
    static int[] result;  // 결과배열
    static boolean[] visited; // 방문체크할 배열

    public static void main(String[] args) {
        nums = new int[]{0, 1, 2};
        n = nums.length;

        result = new int[n];
        visited = new boolean[n];

        perm(0);
    }

    // idx : 현재 위치 판단
    static void perm(int idx) {
        // 기저조건
        if (idx == n) {
            System.out.println(Arrays.toString(result));
            return;
        }

        //재귀부분
        for (int i = 0; i < n; i++) {
            // 사용하지 않은 원소를 사용해야 해!
            // 1. 사용했으면 쳐내
            if (visited[i]) continue;
            result[idx] = nums[i];
            visited[i] = true;  // 방문체크
            perm(idx + 1);
            visited[i] = false; // 원상복구
        }
    }
}
