package LiveClass.심화.순열;

public class 순열01_반복문 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int n = nums.length;

        // 반복문을 이용하여 구현(원소의 수만큼 중첩)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    for (int k = 0; k < n; k++) {
                        if (i != k && j != k) {
                            System.out.printf("%d %d %d\n", nums[i], nums[j], nums[k]);
                        }
                    }
                }
            }
        }
    }
}
