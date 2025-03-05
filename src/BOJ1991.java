import java.io.*;
import java.util.StringTokenizer;

// 트리 순회
public class BOJ1991 {

    static char[][] tree;
    static StringBuilder sb;
    static int n;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/foolsCap.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        // tree[0][0] == 왼자식
        // tree[0][1] == 오른자식
        // tree[0][2] == 자기 자신
        tree = new char[n][3];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char root = st.nextToken().charAt(0);
            char lchild = st.nextToken().charAt(0);
            char rchild = st.nextToken().charAt(0);
            tree[root - 'A'][0] = lchild;
            tree[root - 'A'][1] = rchild;
            tree[root - 'A'][2] = root;
        }

        preOrder(0, sb);
        sb.append('\n');
        inOrder(0, sb);
        sb.append('\n');
        postOrder(0, sb);
        System.out.println(sb);
    }


    private static void preOrder(int index, StringBuilder sb) {

        sb.append(tree[index][2]);
        if (tree[index][0] != '.')
            preOrder(tree[index][0] - 'A', sb);

        if (tree[index][1] != '.')
            preOrder(tree[index][1] - 'A', sb);

    }

    private static void inOrder(int index, StringBuilder sb) {

        if (tree[index][0] != '.')
            inOrder(tree[index][0] - 'A', sb);

        sb.append(tree[index][2]);

        if (tree[index][1] != '.')
            inOrder(tree[index][1] - 'A', sb);

    }

    private static void postOrder(int index, StringBuilder sb) {
        if (tree[index][0] != '.')
            postOrder(tree[index][0] - 'A', sb);

        if (tree[index][1] != '.')
            postOrder(tree[index][1] - 'A', sb);

        sb.append(tree[index][2]);

    }
}
