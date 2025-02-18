import java.util.*;
class Main
{
    static Queue<int[]> queue;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            int[] first = new int[n];
            int[] second = new int[n];
            for (int x = 0; x < n; x++) {
                int a = sc.nextInt();
                first[x] = a;
            }
            for (int x = 0; x < n; x++) {
                int b = sc.nextInt();
                second[x] = b;
            }
            for (int i = 1; i < n; i++) {
                int one = first[i-1] + first[i] - p;
                int two = second[i-1] + first[i];
                int three = second[i-1] + second[i] - p;
                int four = first[i-1] + second[i];
                first[i] = Math.max(one, two);
                second[i] = Math.max(three, four);
            }
            System.out.printf("#%d %d\n", t, Math.max(first[n-1], second[n-1]));
        }
    }
}