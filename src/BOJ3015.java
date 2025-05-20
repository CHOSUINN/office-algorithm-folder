import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;
import java.util.StringTokenizer;

class Node {
    Long val;
    Long cnt;   // 현재 노드도 포함해서 카운트. 1부터 시작

    Node(Long val, Long cnt) {
        this.val = val;
        this.cnt = cnt;
    }
}

// 오아시스 재결합
public class BOJ3015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Node> stack = new Stack<>();

        int n = Integer.parseInt(st.nextToken());
        Node[] arr = new Node[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Node(Long.parseLong(br.readLine()), 1L);
        }

        Long answer = 0L;
        Long maxHeight = -1L;
        for (int i = 0; i < n; i++) {
            // 스택이 비었으면 넣고
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                maxHeight = arr[i].val;
            } else if (Objects.equals(stack.peek().val, arr[i].val)) {
                // 값이 같으면, 연속으로 몇번이나 같은지 확인하자.
                arr[i].cnt += stack.peek().cnt;
                answer+=(stack.peek().cnt);
                if (arr[i].val < maxHeight) {
                    answer++;
                }
                stack.push(arr[i]);
            } else if (stack.peek().val < arr[i].val) {
                while (!stack.isEmpty() && arr[i].val > stack.peek().val) {
                    stack.pop();
                    answer++;
                }
                if (!stack.isEmpty()) {
                    if (Objects.equals(stack.peek().val, arr[i].val)) {
                        arr[i].cnt += stack.peek().cnt;
                        answer+=(stack.peek().cnt);
                        if (arr[i].val < maxHeight) {
                            answer++;
                        }
                    } else {
                        answer++;
                    }
                } else {
                    maxHeight = arr[i].val;
                }
                stack.push(arr[i]);
            } else {
                // 값이 작으면 스택에 추가로 넣는다.
                stack.push(arr[i]);
                answer++;
            }
        }
        System.out.println(answer);

    }
}
