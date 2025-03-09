package LiveClass.심화.순열;

import java.util.Arrays;


/**
 * 정렬되어 순열을 뽑진 않는다. 다만 추가적인 메모리를 필요로하지 않는다.
 */
public class 순열02_swap {
    static int[] nums;
    static int n;

    public static void main(String[] args) {
        nums = new int[]{0, 1, 2};
        n = nums.length;

        perm(0);
    }

    // idx : 현재 위치 판단
    static void perm(int idx) {
        // 기저조건
        if (idx == n) {
            System.out.println(Arrays.toString(nums));
            return;
        }

        //재귀부분
        for (int i = idx; i < n; i++) {
            swap(i, idx);
            perm(idx + 1);
            swap(i, idx);
        }
    }

    static void swap(int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
