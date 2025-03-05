package LiveClass.심화.조합;

public class 조합02_반복문 {
    public static void main(String[] args) {
        
        // 반복문을 이용할때는 R개 고정적으로 사용되면 좋음
        int[] arr = {0, 1, 2, 3, 4,};
        int n = arr.length;
        int r = 3;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                }
            }
        }


    }
}
