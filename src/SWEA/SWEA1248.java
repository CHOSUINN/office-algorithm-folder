package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 공통조상
public class SWEA1248 {

    static int[][] tree;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < tc; t++) {
            String[] inputs = sc.nextLine().split(" ");
            int v = Integer.parseInt(inputs[0]);
            int e = Integer.parseInt(inputs[1]);
            int a = Integer.parseInt(inputs[2]);
            int b = Integer.parseInt(inputs[3]);

            tree = new int[v + 1][4]; // [0] 왼쪽자식, [1] 오른쪽자식 [2] 부모노드, [3] 깊이. treeDepth
            String[] edges = sc.nextLine().split(" ");
            int index = 0;
            for (int i = 0; i < edges.length / 2; i++) {
                int parentNode = Integer.parseInt(edges[index]);
                int childNode = Integer.parseInt(edges[index + 1]);
                if (tree[parentNode][0] == 0)
                    tree[parentNode][0] = childNode;
                else
                    tree[parentNode][1] = childNode;
                tree[childNode][2] = parentNode;
                index += 2;
            }


            // 노드 깊이, 레벨 찾아주기
            cntNodeLevel(1);

            // 레벨이 맞을때까지 부모노드로 이동
            int aParent = a;
            int bParent = b;
            while (true) {
                if (aParent == bParent) break;
                if (tree[aParent][3] > tree[bParent][3]) {
                    aParent = tree[aParent][2];
                } else {
                    bParent = tree[bParent][2];
                }
            }

            cnt = 1;
            // 서브 트리 개수 세주기
            cntNode(aParent);

            System.out.printf("#%d %d %d\n", t + 1, aParent, cnt);
        }

    }

    // 서브 트리 개수 세는 메소드
    private static void cntNode(int startNode) {
        if (tree[startNode][0] != 0) {
            cntNode(tree[startNode][0]);
            cnt++;
        }
        if (tree[startNode][1] != 0) {
            cntNode(tree[startNode][1]);
            cnt++;
        }
    }

    // 각 노드의 레벨 저장
    private static void cntNodeLevel(int startNode) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int num = q.poll();
                tree[num][3] = level;
                if (tree[num][0] != 0)
                    q.offer(tree[num][0]);
                if (tree[num][1] != 0)
                    q.offer(tree[num][1]);
            }
            level++;
        }
    }
}
