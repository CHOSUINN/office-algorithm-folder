import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

// Ai * Aj
public class BOJ32630 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int total = 0;
        for (int i = 0; i < n; i++)
            total += arr[i];


        int temp = arr[n - 2] * arr[n - 1];
        arr[n - 1] = temp;
        arr[n - 2] = temp;

        int sumUp = 0;
        for (int i = 0; i < n; i++)
            sumUp += arr[i];

        int answer = 0;
        if (sumUp > total) {
            answer = sumUp;
        } else
            answer = total;

        System.out.println(answer);



    }
}
