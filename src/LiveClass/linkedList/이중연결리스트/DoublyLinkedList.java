package LiveClass.linkedList.이중연결리스트;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    // 조회
    public Node get(int idx) {
        if (idx < 0 || idx >= size) {
            return null;
        }

        Node curr;

        if (idx < size / 2) {
            curr = head;
            for (int i = 0; i < idx; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            for (int i = size - 1; i > idx; i--) {
                curr = curr.prev;
            }

        }
        return curr;
    }


    // 첫번째 위치 삽입
    public void addFirst(String data) {
        Node node = new Node(data);

        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        size++;

        if (head.next == null) {
            tail = head;
        }
    }

    // 마지막 위치 삽입
    public void addLast(String data) {
        if (size == 0)
            addFirst(data);

        Node node = new Node(data);

        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }


    // 중간 위치 삽입
    public void add(int idx, String data) {
        if (idx < 0 || idx > size) return;

        if (idx == 0) {
            addFirst(data);
            return;
        }

        if (idx == size) {
            addLast(data);
            return;
        }

        Node prevNode = get(idx - 1);
        Node nextNode = prevNode.next;
        Node node = new Node(data);

        prevNode.next = node;
        node.prev = prevNode;

        node.next = nextNode;
        nextNode.prev = node;
        size++;

    }

    // 첫번째 위치 삭제
    public String remove() {
        if (head == null)
            return null;

        String data = head.data;

        Node nextNode = head.next;
        if (nextNode != null) {
            nextNode.prev = null;
        }
        head = nextNode;
        size--;
        if (size == 0)
            tail = null;
        return data;
    }

    // 특정 위치 삭제
    public String remove(int idx) {
        if (idx >= size || idx < 0) {
            return null;
        }

        if (idx == 0) return remove();

        Node prevNode = get(idx - 1);
        Node nextNode = prevNode.next.next;
        String data = prevNode.next.data;

        if (nextNode != null) {
            nextNode.prev = prevNode;
            prevNode.next = nextNode;
        } else {
            prevNode.next = null;
            tail = prevNode;
            size--;
        }
        return data;

    }

    // 출력
    public void printList() {
        Node curr = head;
        if (head == null) {
            System.out.println("공백리스트");
            return;
        }
        while (curr != null) {
            System.out.println(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }


}
