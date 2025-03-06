package LiveClass.심화.분할정복;

import java.util.Arrays;

public class 병합정렬01 {

    static int[] arr = {7, 5, 6, 8, 1, 2, 3, 39};
    static int n = arr.length;

    // 임시공간
    static int[] temp = new int[n];

    public static void main(String[] args) {

        System.out.println(Arrays.toString(arr));
        mergeSort(0, n - 1);
        System.out.println(Arrays.toString(arr));
    }


    static void mergeSort(int start, int end) {

//        // 방법1
//        if (start >= end) return;
//        int mid = (start + end) / 2;
//        mergerSort(start, mid);
//        mergerSort(mid + 1, end);
//        merge(start, mid, end);
//        // 병합하는 메서드 호출

        // 방법2
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            // 병합하는 메서드 호출
            merge(start, mid, end);
        }

    }

    static void merge(int start, int mid, int end) {
        // 정렬하고자 하는 부분 배열들의 시작위치를 초기화
        int l = start;
        int r = mid + 1;

        int idx = start; // 임시 배열의 인덱스

        // 한쪽 구간 정렬
        while (l <= mid && r <= end) {
            if (arr[l] <= arr[r]) {
                temp[idx++] = arr[l++];
            } else {
                temp[idx++] = arr[r++];
            }
        }

        // 남은 구간 정렬
        if (l <= mid) {
            for (int i = l; i <= mid; i++) {
                temp[idx++] = arr[i];
            }
        } else {
            for (int i = r; i <= end; i++) {
                temp[idx++] = arr[i];
            }

        }

        // 원본에 덮어씌우기
        for (int i = start; i <= end; i++) {
            arr[i] = temp[i];
        }
        
    }

}
