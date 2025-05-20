//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class BOJ3190 {
//
//    static Map<String, Integer> apples;
//    static int[][] map;
//    static Deque<Node> snake;
//    static PriorityQueue<Time> directions;
//    static int gameTime;
//    static int snakeHead;  // 1 == 상, 2 == 우, 3 == 하, 4 == 좌;
//
//    static class Node {
//        int x;
//        int y;
//
//        public Node(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    static class Time implements Comparable<Time> {
//        int time;
//        String dir;
//
//        public Time(int time, String dir) {
//            this.time = time;
//            this.dir = dir;
//        }
//
//        @Override
//        public int compareTo(Time o) {
//            return this.time - o.time;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//        map = new int[n + 1][n + 1];
//        snake = new ArrayDeque<>();
//        snake.add(new Node(1, 1));
//
//        apples = new HashMap<>();
//        for (int i = 1; i <= k; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int x = Integer.parseInt(st.nextToken());
//            int y = Integer.parseInt(st.nextToken());
//
//            apples.put(x + "," + y, 1);
//        }
//
//        directions = new PriorityQueue<>();
//        st = new StringTokenizer(br.readLine(), " ");
//        int l = Integer.parseInt(st.nextToken());
//        for (int i = 0; i < l; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int x = Integer.parseInt(st.nextToken());
//            String s = st.nextToken();
//
//            directions.offer(new Time(i, s));
//        }
//
//        gameTime = 0;
//        snakeHead = 2; // 오른쪽을 바라보고 시작
//        boolean result = false; // true가 뜨면 벽에 부딫힌거임.
//
//        for (Time time : directions) {
//            result = moveSnake(time);
//            if (result)
//                break;
//        }
//
//
//        System.out.println(gameTime);
//    }
//
//    private static boolean moveSnake(Time time) {
//
//        while (true) {
//            gameTime++;
//            if (gameTime == time.time) {
//                changeSnakeHead(time.dir);
//            }
//            Node snakeHeadCoordinate = snake.poll();
//            int[] temp = getNextcoordinate(snakeHeadCoordinate);
//            snake.addFirst(new Node(temp[0], temp[1]));
//
//            if ()
//
//            // 해당 이동 위치가 사과위치인지 확인
//            String corr = temp[0] + "," + temp[1];
//            if (!apples.containsKey(corr))
//                snake.pollLast();
//
//
//
//
//        }
//
//    }
//
//    private static void changeSnakeHead(String dir) {
//        if (dir.equals("D")) {
//            snakeHead++;
//            if (snakeHead >= 5)
//                snakeHead = snakeHead - 4;
//        } else if (dir.equals("L")) {
//            snakeHead--;
//            if (snakeHead <= 0)
//                snakeHead = snakeHead + 4;
//        }
//    }
//
//    private static int[] getNextcoordinate(Node node) {
//        if (snakeHead == 1)
//            return new int[]{node.x - 1, node.y};
//        else if (snakeHead == 2)
//            return new int[]{node.x, node.y + 1};
//        else  if (snakeHead == 3)
//            return new int[]{node.x + 1, node.y};
//        else
//            return new int[]{node.x, node.y - 1};
//    }
//
//}
