package LiveClass.기초.linkedList.단일연결리스트;

// 데이터 필드, 링크(다음) 필드
public class Node {
    // 데이터 필드 String으로 고정했지만, 제네릭으로 처리할 수 있다.
    public String data;
    public Node link;

    public Node(String data) {
        this.data = data;
        this.link = null;
    }
    
}
