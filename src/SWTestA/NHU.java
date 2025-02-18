package SWTestA;

import java.util.*;
class NHU
{
    static Queue<int[]> queue;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            queue = new LinkedList<>();
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
            int[] start1 = {first[0],1,1};
            int[] start2 = {second[0],2,1};
            queue.add(start1);
            queue.add(start2);
            int max = 0;
            while (!queue.isEmpty()) {
                int[] polled = queue.poll();
                int sum = polled[0];
                int category = polled[1];
                int nextfeed = polled[2];
                if (nextfeed > n-1) {
                    if (sum > max) {
                        max = sum;
                    }
                }
                else {
                    if (category == 1) {
                        int[] update1 = {sum+first[nextfeed]-p, 1, nextfeed+1};
                        int[] update2 = {sum+second[nextfeed], 2, nextfeed+1};
                        if (update1[0] > update2[0]) {
                            queue.add(update1);
                        } else {
                            queue.add(update2);
                        }
                    } else {
                        int[] update1 = {sum+first[nextfeed], 1, nextfeed+1};
                        int[] update2 = {sum+second[nextfeed]-p, 2, nextfeed+1};
                        if (update1[0] > update2[0]) {
                            queue.add(update1);
                        } else {
                            queue.add(update2);
                        }
                    }
                }
            }
            System.out.printf("#%d %d\n", t, max);
        }
    }
}