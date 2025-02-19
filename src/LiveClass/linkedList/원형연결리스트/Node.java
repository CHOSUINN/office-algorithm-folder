package LiveClass.linkedList.원형연결리스트;


// 필요하다면 단일도 가능
public class Node {
    public String data;
    public Node prev;
    public Node next;

    public Node(String data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
