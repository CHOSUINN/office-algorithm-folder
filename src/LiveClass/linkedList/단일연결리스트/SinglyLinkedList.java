package LiveClass.linkedList.단일연결리스트;

public class SinglyLinkedList {
    private Node head;
    private int size;

    public SinglyLinkedList () {
        // 없어도 괜찮음
        this.head = null;
        this.size = 0;
    }

    // 조회
    public Node get(int idx) {

        //idx가 정상적인지 확인
        if (idx < 0 || idx >= size) {
            return null;
        }

        Node curr = head;
        for (int i = 0; i < idx; i++) {
            curr = curr.link;
        }

        return curr;
    }

    // 노드 추가
    public void addFirst(String data) {
        Node node = new Node(data);

        node.link = head;

        head = node;
        size++;
    }

    public void addLast(String data) {
        if (size == 0) {
            addFirst(data);
            return;
        }
        Node node = new Node(data);

        Node curr = head;

        while (curr.link != null) {
            curr = curr.link;
        }

        curr.link = node;
        size++;

    }

    public void add(int idx, String data) {
        if (idx < 0 || idx > size) {
            return;
        }

        if (idx == 0) {
            addFirst(data);
            return;
        }

        if (idx == size) {
            addLast(data);
            return;
        }

        Node pre = get(idx - 1);
        Node node = new Node(data);

        node.link = pre.link;
        pre.link = node;

        size++;
    }

    public String remove() {
        if (head == null) {
            return null;
        }

        String data = head.data;
        head = head.link;
        size--;
        return data;
    }

    public String remove(int idx) {
        if (idx == 0) return remove();
        if (idx < 0 || idx >= size) return null;

        Node pre = get(idx - 1);
        Node rm = pre.link;

        String data = rm.data;

        pre.link = rm.link;
        size--;

        return data;
     }

     public void printList() {
        Node curr = head;
         if (head == null) {
             System.out.println("공백리스트야");
             return;
         }

         while (curr != null) {
             System.out.print(curr.data + "->");
             curr = curr.link;
         }

         System.out.println();
     }



}
