//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//// 이진 검색 트리
//
///**
// * 전위순회로 들어오는 값들. 후위순회로 출력하기
// * 전위순회의 값들을 순차적으로 dfs하듯이 값을 넣으면 될듯하다.
// * List에 Node를 관리하는 식으로 하는게 좋아보인다.
// */
//
//class Node {
//    int val;
//    Node left;
//    Node right;
//
//    public Node (int val) {
//        this.val = val;
//        this.left = null;
//        this.right = null;
//    }
//}
//
//public class BOJ5639 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st;
//
//        List<Node> arr = new ArrayList<>();
//        while (true) {
//            st = new StringTokenizer(br.readLine(), " ");
//            if (st.nextToken() == null)
//                break;
//
//            int temp = Integer.parseInt(st.nextToken());
//            Node node = new Node(temp);
//
//        }
//
//    }
//}
//
