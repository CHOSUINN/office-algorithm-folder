package LiveClass.기초.linkedList.연결스택;

public class LinkedStack {
    public Node top;

    // push
    public void push(int data) {
        Node node = new Node(data);
        node.link = top;
        top = node;
    }

    // pop
    public int pop() {
        if (top == null) {
            // 공백 스택
            return -1; // 문제의 범위를 고려해서 반환값을 설정해야한다.
        }
        int data = top.data;
        top = top.link;
        return data;


    }

    // peek
    public int peek() {
        if (top == null) {
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

}
