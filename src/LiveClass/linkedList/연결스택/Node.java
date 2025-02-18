package LiveClass.linkedList.연결스택;

public class Node {
    int data;
    Node link;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", link=" + link +
                '}';
    }
}
