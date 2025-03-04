package LiveClass.기초.tree;

public class Tree01순회 {

    public static char[] tree = new char[]{' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', ' ', ' ', 'H', 'I'};
    public static int N = tree.length;

    public static void main(String[] args) {
        preOrder(1);
        System.out.println();
        inOrder(1);
        System.out.println();
        postOrder(1);

    }

    // 전위 순히 v는 노드의 번호
    public static void preOrder(int v) {

        // v라는 노드의 번호가 유효한지 확인
        if (v < N) {
            // 방문처리
            if (tree[v] != ' ')
                System.out.print(tree[v]);

            // 왼쪽자식 탐방
            preOrder(v * 2);
            // 오른쪽 자식 탐방
            preOrder(v * 2 + 1);
            //
        }
    }


    // 중위 순히 v는 노드의 번호
    public static void inOrder(int v) {

        // v라는 노드의 번호가 유효한지 확인
        if (v < N) {

            // 왼쪽자식 탐방
            preOrder(v * 2);

            // 방문처리
            if (tree[v] != ' ')
                System.out.print(tree[v]);

            // 오른쪽 자식 탐방
            preOrder(v * 2 + 1);
        }
    }

    // 후위 순히 v는 노드의 번호
    public static void postOrder(int v) {

        // v라는 노드의 번호가 유효한지 확인
        if (v < N) {

            // 왼쪽자식 탐방
            preOrder(v * 2);

            // 오른쪽 자식 탐방
            preOrder(v * 2 + 1);

            // 방문처리
            if (tree[v] != ' ')
                System.out.print(tree[v]);
        }
    }

    


}
