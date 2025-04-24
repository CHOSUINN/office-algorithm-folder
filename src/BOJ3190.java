import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ3190 {

    static int[][] map;
    static Deque<Node> snake;
    static PriorityQueue<Time> directions;
    static int gameTime;
    static int snakeHead;  // 1 == 상, 2 == 우, 3 == 하, 4 == 좌;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Time implements Comparable<Time> {
        int time;
        String dir;

        public Time(int time, String dir) {
            this.time = time;
            this.dir = dir;
        }

        @Override
        public int compareTo(Time o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        snake = new ArrayDeque<>();
        snake.add(new Node(1, 1));

        Map<String, Integer> apples = new HashMap<>();
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            apples.put(x + "," + y, 1);
        }

        directions = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine(), " ");
        int l = Integer.parseInt(st.nextToken());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            directions.offer(new Time(i, s));
        }

        gameTime = 0;
        snakeHead = 2; // 오른쪽을 바라보고 시작
        boolean result = false; // true가 뜨면 벽에 부딫힌거임.

        for (Time time : directions) {
            result = moveSnake(time);
            if (result)
                break;
        }


        System.out.println(gameTime);
    }

    private static boolean moveSnake(Time time) {

        for (int i = 0; i < time.time; i++) {
            gameTime++;
            if (gameTime == time.time) {
                changeSnakeHead(time.dir);
            }
            Node snakeHeadCoordinate = snake.poll();
            int[] temp = getNextcoordinate(snakeHeadCoordinate);
        }



        
        // 뱀을 이동시킨다.
        // 뱀 이동처리 과정. deque의 앞부분에 node추가. 꼬리 node 하나 삭제
        // 머리 방향에 따라 추가해야할 좌표를 반환받는 메서드 생성
        getNextMap(time.dir);
        
        // 만약 이동할 공간이 map밖이면 충돌처리
        
        // 만약 이동할 공간이 사과의 위치면, deque 앞부분에 node추가만 함
        
        // 만약 이동할 공간이 사과가 없는 곳이면, deque 앞부분에 node추가, 꼬리 node 하나 삭제
        
    }

    private static void changeSnakeHead(String dir) {
        if (dir.equals("D")) {
            snakeHead++;
            if (snakeHead >= 5)
                snakeHead = snakeHead - 4;
        } else if (dir.equals("L")) {
            snakeHead--;
            if (snakeHead <= 0)
                snakeHead = snakeHead + 4;
        }
    }

    private static int[] getNextcoordinate(Node node) {

    }

}
