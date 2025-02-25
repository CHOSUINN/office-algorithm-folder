//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//// 듣보잡
//public class BOJ1764 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        HashMap<String, Integer> hm = new HashMap<>();
//        for (int i = 0; i < n; i++){
//            st = new StringTokenizer(br.readLine());
//            String input = st.nextToken();
//            hm.put(input, 0);
//        }
//
//        List<String> answer = new ArrayList<>();
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            String temp = st.nextToken();
//            if (!hm.containsKey(temp))
//                answer.add(temp);
//        }
//
//        Collections.sort(new Comparator<>())
//
//    }
//}
