package LiveClass;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {

        int[] arr = {3, 13, 26, 88, 22, 11, 54, 12};

        countingSort(arr);

    }


    static void countingSort(int[] arr) {
        // 1. 가장 큰 값을 찾는다.(문제에 음수가 나오는경우 최저 값도 찾아야함)
        int k = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > k) k = arr[i];
        }

        // 2. count하기
        int[] count = new int[k + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // 3. 누적합 구하기(해당 원소가 어디 위치에 있어야 하는지 결정!)
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];
        }


        // 4. 역방향으로 순회하면서 값 할당 (안정 정렬)
        int[] sortArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            int idx = count[num] - 1;
            sortArr[idx] = num;
            count[num]--;
        }

        System.out.println(Arrays.toString(sortArr));

    }
}
