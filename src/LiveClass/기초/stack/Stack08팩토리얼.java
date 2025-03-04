package LiveClass.기초.stack;

public class Stack08팩토리얼 {
    public static void main(String[] args) {
        System.out.println(fact(5));
        System.out.println(fact(12)); // int형으로 처리할 수 없어서 이상한 값이 나온다(overflow)

        int result = 1;
        for (int i = 1; i <= 12; i++) {
            result *= i;
        }
    }

    public static int fact(int n) {
        if (n == 0 || n == 1)
            return 1;

        return n * fact(n - 1);
    }
}
