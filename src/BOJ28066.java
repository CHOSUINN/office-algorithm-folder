import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 타노스는 요세푸스가 밉다
class Node {
    int animalNum;

    public Node(int num) {
        animalNum = num;
    }
}


public class BOJ28066 {

    static int answer;
    static int n;
    static int k;
    static List<Node> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            arr.add(new Node(i));
        }

        f(0);
        System.out.println(arr.get(0).animalNum);
    }


    private static void f(int idx) {
        answer++;

        if (arr.size() == 1)
            return;

        if (k - 1 > arr.size()) {
            answer++;
            return;
        }

        for (int i = 0; i < k - 1; i++) {
            arr.remove(idx + 1);
        }

        f(idx + 1);




    }
}
