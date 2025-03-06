package LiveClass.심화.분할정복;

public class 퀵정렬01_로무토파티션 {

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
        int pivot = arr[end];

        int i = start - 1; // 작은값들의 경계

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1;


    }

}
