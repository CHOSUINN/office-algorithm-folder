import java.util.*;

class Node {
    int x;
    int y;
    int depth;
    int k;
    boolean[][] visited;

    public Node(int x, int y, int depth, int k, boolean[][] visited) {
        this.x = x;
        this.y = y;
        this.depth = depth;
        this.k = k;
        this.visited = visited;
    }
}

// 등산로 조성
public class SWEA1949 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] mountain;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            sb.append("#").append(t + 1);
            st = new StringTokenizer(sc.nextLine());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            mountain = new int[n][n];

            int maxHeight = Integer.MIN_VALUE;
            List<Node> height = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(sc.nextLine());
                for (int j = 0; j < n; j++) {
                    mountain[i][j] = Integer.parseInt(st.nextToken());

                    if (maxHeight < mountain[i][j]) {
                        maxHeight = mountain[i][j];
                        height.clear();
                        Node temp = new Node(i, j, 1, k, new boolean[n][n]);
                        height.add(temp);
                    } else if (maxHeight == mountain[i][j]) {
                        Node temp = new Node(i, j, 1, k, new boolean[n][n]);
                        height.add(temp);
                    }
                }
            }

            int maxRoad = Integer.MIN_VALUE;
            for (int i = 0; i < height.size(); i++) {
                int num = bfs(height.get(i));
                if (maxRoad < num)
                    maxRoad = num;
                maxRoad = Math.max(num, maxRoad);
            }

            sb.append(" ").append(maxRoad);
            System.out.println(sb);
            sb.setLength(0);
        }
    }

    private static int bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        node.visited[node.x][node.y] = true;
        int max = 1;

        while (!q.isEmpty()) {
            Node temp = q.poll();
            for (int delta = 0; delta < 4; delta++) {
                int r = temp.x + dx[delta];
                int c = temp.y + dy[delta];
                int depth = temp.depth;
                int k = temp.k;
                if (r < 0 || r >= n || c < 0 || c >= n || temp.visited[r][c]) continue;

                if (mountain[temp.x][temp.y] > mountain[r][c]) {
                    Node tmp = new Node(r, c, depth + 1, k, ft_arrayCopy(temp.visited));
                    tmp.visited[r][c] = true;
                    q.offer(tmp);
                } else if (mountain[temp.x][temp.y] == mountain[r][c] && k != 0 ) {
                    Node tmp = new Node(r, c, depth + 1, 0, ft_arrayCopy(temp.visited));  // 깎고 지나갈때의 경우의 수
                    tmp.visited[r][c] = true;
                } else if (mountain[temp.x][temp.y] < mountain[r][c] && k != 0) {
                    if (mountain[temp.x][temp.y] >= mountain[r][c] - k) {
                        Node tmp = new Node(r, c, depth + 1, 0, ft_arrayCopy(temp.visited));
                        tmp.visited[r][c] = true;
                    }
                } else {
                    Math.max(max, depth);
                }
            }
        }
        return max;
    }

    private static boolean[][] ft_arrayCopy(boolean[][] visited) {
        boolean[][] copy = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = visited[i][j];
            }
        }
        return copy;
    }

}
