package LiveClass.심화.그래프;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_02_인접리스트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // V, E의 개수를 입력 받는다.
        int v = sc.nextInt(); // 정점의 개수 (0번 시작인지 1번 시작인지 확인)
        int e = sc.nextInt(); // 간선의 개수

        List<Integer>[] adjList = new ArrayList[v];

        for (int i = 0; i < e; i++) {
            // 간선 입력 받기.
            int a = sc.nextInt(); // 연결된 두개의 정점의 정보
            int b = sc.nextInt();

            // 가중치를 같이 저장하고 싶다.
            // 1. class 이용 저장
            // 2. int[] 이용 저장
            adjList[a].add(b);
            adjList[b].add(a); //무향이라면...필요없다.


        }
    }
}
