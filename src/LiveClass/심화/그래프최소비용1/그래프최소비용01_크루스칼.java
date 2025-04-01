package LiveClass.심화.그래프최소비용1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 그래프최소비용01_크루스칼 {

    static int[] p; // 대표를 저장할 배열
    static int[] rank; // 균형있는 트리 -> 안쓴다

    // 간선을 저장!
    // 1. edge 클래스 생성
    // 2. int[]

    static class Edge implements Comparable<Edge>{
        int s, e, cost;

        public Edge(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(input);

        int V = sc.nextInt(); // 정점의 개수
        int E = sc.nextInt(); // 간선의 개수

        Edge[] edges = new Edge[E];

        for (int i = 0; i < E; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int cost = sc.nextInt();

            edges[i] = new Edge(s, e, cost);
        }
        
        // 1. 정렬을 하자 -> 가중치 오름차순으로 정렬

        //1-1 정렬방법
//        Arrays.sort(edges);

        //1-2 정렬방법2(익명클래스 사용)
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }
        });

        // 정렬확인
        for (Edge e : edges) {
            System.out.println(e);
        }

        // 2. V-1개의 간선을 뽑는다.(사이클 X)
        // 서로소 집합( 유니온 파인드)
        p = new int[V];

        // make-set을 통해서 각자 본인이 대표가 되도록 초기화
        for (int i = 0; i < V; i++) {
            p[i] = i;
            makeSet(i); // 함수로 빼서 해도 된다. 편한방법 사용
        }

        int answer = 0; // 누적 비용
        int pick  = 0;  // 내가 뽑은 개수
        for (int i = 0; i < E; i++) {
            int s = edges[i].s;
            int e = edges[i].e;

            // 사이클 검사를 수행하자
            if (findSet(s) != findSet(e)) {
                // 사이클이 없으면 합치자. 합쳤다는것은 해당 간선을 뽑았다는 것.
                union(s, e);
                pick++;
                answer += edges[i].cost;
            }

            if (pick == V-1) break;

        }
        System.out.println(answer);

    }

    private static void union(int x, int y) {
        // rank를 고려하고 있지 않다.
        p[findSet(y)] = findSet(x);
    }

    private static int findSet(int x) {
        // 기교없이 순수하게 코드 짠 방법
//        if (x == p[x]) return x;
//        return findSet(p[x]);
        
        // 경로압축(path compression) 방법. 이게 조금 더 좋다.
        if (x != p[x])
            p[x] = findSet(p[x]);
        return p[x];
    }

    private static void makeSet(int x) {
        p[x] = x;
    }


    static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
            + "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";


}
