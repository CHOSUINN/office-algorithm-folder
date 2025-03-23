//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//// 이진 검색 트리
//
///**
// *
// *
// */
//class Node {
//    int val;
//    Node left;
//    Node right;
//    Node parent;
//
//    public Node(int val) {
//        this.val = val;
//        this.left = null;
//        this.right = null;
//        this.parent = null;
//    }
//
//    public Node(int val, Node parent) {
//        this.val = val;
//        this.left = null;
//        this.right = null;
//        this.parent = parent;
//    }
//}
//
//public class BOJ5639 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        Node curr = new Node(Integer.parseInt(st.nextToken()));
//        while (true) {
//            st = new StringTokenizer(br.readLine(), " ");
//            String temp = st.nextToken();
//            if (temp == null)
//                break;
//
//            Node node = new Node(Integer.parseInt(temp));
//
//        }
//
//
//
//
//    }
//}
//
////public class BOJ5639 {
////    public static void main(String[] args) throws IOException {
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        StringBuilder sb = new StringBuilder();
////        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
////
////        Stack<Integer> stack = new Stack<>();
////        int firstVal = Integer.parseInt(st.nextToken());
////        int secondVal;
////        boolean flag = false; // 만약 최하위 노드에 한번 도달했으면 그 때부터는 출력에 중복이 생기지 않도록 해준다. 도달했으면 true로 변경
////        while (true) {
////            st = new StringTokenizer(br.readLine(), " ");
////            String temp = st.nextToken();
////            if (temp == null)
////                break;
////
////             secondVal = Integer.parseInt(temp);
////             if (secondVal > firstVal) {
////                 if (!flag) {
////                     sb.append(firstVal).append("\n");
////                     flag = true;
////                 }
////                 sb.append(secondVal).append("\n");
////
////                 if (stack.isEmpty())
////                     break;
////                 firstVal = stack.pop();
////                 sb.append(firstVal).append("\n");
////             } else {
////                 stack.push(firstVal);
////                 firstVal = secondVal;
////             }
////
////        }
////        System.out.println(sb);
////
////    }
////}
//
