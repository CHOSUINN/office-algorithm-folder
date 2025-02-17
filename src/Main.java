import java.util.*;
class Solution
{
    final static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) throws Exception
    {
        int T = sc.nextInt();
        for (int t=1;t<=T;t++) {
            System.out.println("#" + t + " " + run());
        }
    }
    private static String run() {
        int n = sc.nextInt();
        byte[][] arr = new byte[n][n];
        long sum=0;
        for (int i=0;i<n;i++) {
            String str = sc.next();
            for (int j=0;j<n;j++) {
                arr[i][j] = (byte)Character.getNumericValue(str.charAt(j));
            }
        }
        for (int i=0;i<n;i++) {
            int diff = Math.min(i, n-i-1);
            for (int j=n/2-diff;j<n/2+1+diff;j++) {
                sum+=arr[i][j];
            }
        }
        return String.valueOf(sum);
    }
}