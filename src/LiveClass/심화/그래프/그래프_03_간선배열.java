package LiveClass.심화.그래프;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_03_간선배열 {
    
    // 문제 안에 클래스를 정의하는 경우가 왕왕 나온다.
    static class Edge {
        int a, b, w; // 시작, 끝, 가중치

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        // 확인용이므로 굳이 안만들어도 됨.
        @Override
        public String toString() {
            return "Edge{" +
                    "a=" + a +
                    ", b=" + b +
                    ", w=" + w +
                    '}';
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // V, E의 개수를 입력 받는다.
        int v = sc.nextInt(); // 정점의 개수 (0번 시작인지 1번 시작인지 확인)
        int e = sc.nextInt(); // 간선의 개수

        Edge[] edges = new Edge[e]; // 간선의 배열 (객체 배열)

        for (int i = 0; i < e; i++) {
            // 간선 입력 받기.
            int a = sc.nextInt(); // 연결된 두개의 정점의 정보
            int b = sc.nextInt();
            int w = sc.nextInt(); // 가중치 값 / 없다면 1을 저장

            edges[i] = new Edge(a, b, w);
        }

        // 2차원 배열을 이용해서 저장하자. 단 간선의 정보가 전부 정수일때.
        int[][] edges3 = new int[e][3]; // [0] : 시작정점, [1]:끝정점, [2]: 가중치
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            edges3[i][0] = a;
            edges3[i][1] = b;
            edges3[i][2] = w;
        }
    }
}
