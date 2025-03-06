package LiveClass.심화.분할정복;

public class 거듭제곱01_반복문 {
    public static void main(String[] args) {

    }


    // c:
    // n :
    static int pow(int c, int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= c; // result = result * c;
        }
        return result;
    }

    static int pow2(int c, int n) {
        if (n == 1) return c;
        return c * pow2(c, n - 1);
    }

}
