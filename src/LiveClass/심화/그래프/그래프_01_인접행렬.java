package LiveClass.심화.그래프;

import java.util.Scanner;

public class 그래프_01_인접행렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // V, E의 개수를 입력 받는다.
        int v = sc.nextInt(); // 정점의 개수 (0번 시작인지 1번 시작인지 확인)
        int e = sc.nextInt(); // 간선의 개수
        
        int[][] adjArr = new int[v][v]; // 만약 시작정점이 1이라면 v + 1로 만들기

        for (int i = 0; i < e; i++) {
            // 간선 입력 받기.
            int a = sc.nextInt(); // 연결된 두개의 정점의 정보
            int b = sc.nextInt();
            int w = sc.nextInt(); // 가중치 값 / 없다면 1을 저장.

            adjArr[a][b] = 1; // 가중치가 없다면 1을 있다면 w 저장
            adjArr[b][a] = 1; // 유향이라면 이건 작성하면 안된다.

//            adjArr[a][b] = adjArr[b][a] = w; 이렇게 작성도 가능


        }
    }
}
