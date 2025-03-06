package LiveClass.심화.분할정복;

public class 퀵정렬01_호어파티션 {

    static int[] arr = {7, 5, 6, 8, 1, 2, 3, 39};
    static int n = arr.length;

    public static void main(String[] args) {

    }

    static void quickSort(int start, int end) {
        if (start < end) {
            int pivot = partition(start, end);
            quickSort(start, pivot - 1);
            quickSort(pivot + 1, end);
        }
    }

    private static int partition(int start, int end) {
        int pivot = arr[start]; // 첫번째 요소를 피봇이라고 결정
        
        int l = start + 1;
        int r = end;

        while (l <= r) {
            //l : pivot 보다 큰 값을 찾을 때까지 이동
            while (l <= r && arr[l] <= pivot) l++;
            
            // r : pivot 보다 작거나 같은 값을 찾을 때까지 이동
            while (arr[r] > pivot) r--;

            // 아직 교차가 되지 않았다
            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        
        // 마지막에 r과 피봇의 위치를 교환
        int temp = arr[start];
        arr[start] = arr[r];
        arr[r] = temp;

        return r; //피봇위치
    }

}
