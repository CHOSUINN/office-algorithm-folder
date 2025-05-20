//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//class Node {
//    char val;
//    Node left;
//    Node right;
//
//    public Node(char val) {
//        this.val = val;
//        this.left = null;
//        this.right = null;
//    }
//}
//
////에디터
//public class BOJ1406 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        String temp = st.nextToken();
//        Node curr = new Node('0');
//        for (int i = 0; i < temp.length(); i++) {
//            Node node = new Node(temp.charAt(i));
//            curr.right = node;
//            node.left = curr;
//            curr = node;
//        }
//
//        st = new StringTokenizer(br.readLine(), " ");
//        int m = Integer.parseInt(st.nextToken());
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            String action  = st.nextToken();
//
//            switch(action) {
//
//                case "L" :
//                    if (curr.left != null)
//                        curr = curr.left;
//                    break;
//                case "D":
//                    if (curr.right != null)
//                        curr = curr.right;
//                    break;
//                case "B" :
//                    if (curr.left != null) {
//                        Node temp1 = curr.right;
//                        Node temp2 = curr.left;
//                        temp1.left = temp2;
//                        temp2.right = temp1;
//                    }
//                    break;
//                case "P" :
//                    Node node = new Node(st.nextToken().charAt(0));
//                    if (curr.right == null) {
//                        curr.right = node;
//                        node.left = curr;
//                        curr = node;
//                    } else {
//                        Node temp1 = curr.left;
//                        Node temp2 = curr.right;
//                        node.left = temp1;
//                        node.right = temp2;
//                        temp2.left = node;
//                        temp1.right = node;
//                    }
//                    break;
//            }
//        }
//
//        while (curr.left != null)
//            curr = curr.left;
//
//        while (curr.right != null) {
//             sb.append(curr.right.val);
//            curr = curr.right;
//        }
//
//        System.out.println(sb);
//
//
//    }
//}
//
///**
// * 스택 풀이
// */
////public class BOJ1406 {
////    public static void main(String[] args) throws IOException {
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        StringBuilder sb = new StringBuilder();
////        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
////
////        String temp = st.nextToken();
////        Stack<Character> leftStack = new Stack<>();
////        Stack<Character> rightStack = new Stack<>();
////
////        for (int i = 0; i < temp.length(); i++)
////            leftStack.push(temp.charAt(i));
////
////        st = new StringTokenizer(br.readLine(), " ");
////        int m = Integer.parseInt(st.nextToken());
////        for (int i = 0; i < m; i++) {
////            st = new StringTokenizer(br.readLine(), " ");
////            String action = st.nextToken();
////
////            switch (action) {
////                case "L" :
////                    if (!leftStack.isEmpty())
////                        rightStack.push(leftStack.pop());
////                    break;
////
////                case "D" :
////                    if (!rightStack.isEmpty())
////                        leftStack.push(rightStack.pop());
////                    break;
////
////                case "B" :
////                    if (!leftStack.isEmpty())
////                        leftStack.pop();
////                    break;
////
////                case "P" :
////                    leftStack.push(st.nextToken().charAt(0));
////            }
////        }
////
////        while (!leftStack.isEmpty())
////            rightStack.push(leftStack.pop());
////
////        while (!rightStack.isEmpty())
////            sb.append(rightStack.pop());
////
////        System.out.println(sb);
////    }
////}