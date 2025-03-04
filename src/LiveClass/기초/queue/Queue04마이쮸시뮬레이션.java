package LiveClass.기초.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue04마이쮸시뮬레이션 {

    static class Person {
        int num;
        int cnt;

        public Person(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(sc.nextLine());
            int ans = 0;
            int pNum = 1;

            // [0] == 번호
            // [1] == 개수
            //Queue<int[]> queue = new LinkedList<>();

            // 객체로 관리
            Queue<Person> queue = new LinkedList<>();
            queue.add(new Person(pNum++, 1));

            while (n > 0) {

                Person p = queue.poll();
                n -= p.cnt;
                if (n <= 0) {
                    ans = p.num;
                    break;
                } else {
                    p.cnt++;
                    queue.offer(p);
                    queue.add(new Person(pNum++, 1));
                }


            }

            System.out.printf("#%d %d\n", t + 1, ans);
        }


    }
}
