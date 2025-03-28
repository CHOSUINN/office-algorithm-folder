package LiveClass.심화.그래프비용2.APS응용_Day09_그래프최소비용2;

import java.util.Scanner;

public class 그래프최소비용02_프림_반복문 {

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(input);

        int v = sc.nextInt(); // 정점 -> 0번부터 시작
        int E = sc.nextInt(); // 간선

        int[][] adj = new int[v][v]; // 인접행렬

        for (int i = 0; i < E; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int cost = sc.nextInt();

            // 무향 그래프
            adj[s][e] = adj[e][s] = cost;
        }

        int[] p = new int[v]; // 부모의 정보를 저장
        int[] dist = new int[v]; // key 값을 저장하는 배열
        boolean[] visited = new boolean[v]; // 트리에 소속인지 아닌지 기록

        //1. dist배열을 초기화. 아주 큰 값으로.
        for (int i = 0; i < v; i++) {
            dist[i] = INF;
            p[i] = -1; // 0번 정점도 있으니까 -1로 초기화 해두면 좋다.
        }

        //2. 시작정점을 고른다.
        dist[0] = 0;
        int answer = 0;

        //3. 전체를 반복문을 수행하면서 정점을 뽑는다.
        for (int i = 0; i < v; i++) {
            // 3-1. 가장 작은 값을 고름
            int min = INF;
            int idx = -1;
            for (int j = 0; j < v; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    idx = j;
                }
            }
            // idx는 가장 작은 이번에 뽑은 정점이 된다.
            visited[idx] = true;
            answer += dist[idx];

            // 3-2. 가장 작은 정점 뽑은 후, 연결된 간선으로 갱신
            for (int j = 0; j < v; j++) {
                // 방문하지 않았고, idx와 연결되어 있는, 갱신의 여지가 있으면
                if (!visited[j] && adj[idx][j] != 0 && dist[j] > adj[idx][j]) {
                    dist[j] = adj[idx][j];
                    p[j] = idx; //부모 정보 갱신
                }
            }

        }

        System.out.println(answer);

        
    }

    static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
            + "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";


}
