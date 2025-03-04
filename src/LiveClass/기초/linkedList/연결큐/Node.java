package LiveClass.기초.linkedList.연결큐;

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
