package LiveClass.심화.분할정복;

public class 거듭제곱02_분할정복 {
    public static void main(String[] args) {
        System.out.println(pow(2, 1));

        Math.pow(0, 0);

    }

    static int pow(int c, int n) {

        if (n == 0) return 1;
        // 기저 조건
        if (n == 1) return c;

        // 재귀 부분 (1. 홀수일때, 2. 짝수일때)
        if (n % 2 == 1) {
            return pow(c, (n - 1) / 2) * pow(c, (n - 1) / 2) * c;
        } else {
            return pow(c, n / 2) * pow(c, n / 2);
        }
    }

    static int pow2(int c, int n) {

        if (n == 0) return 1;
        // 기저 조건
        if (n == 1) return c;

        // 재귀 부분 (1. 홀수일때, 2. 짝수일때)
        if (n % 2 == 1) {
            int temp = pow2(c, (n - 1) / 2);
            return temp * temp * c;
        } else {
            int temp = pow2(c, n / 2);
            return temp * temp;
        }
    }

}
