package LiveClass;

public class Stack07재귀함수 {

    static int cnt = 0;
    public static void main(String[] args) {

    }

    public static void func1 () {
        System.out.println("func1 호출" + cnt++);
        func1();
    }

    public static void func2(int num) {

        if (num < 0) {
            return;
        } else {
            System.out.println("func2호출");
            func2(num - 1);
        }

    }

}
