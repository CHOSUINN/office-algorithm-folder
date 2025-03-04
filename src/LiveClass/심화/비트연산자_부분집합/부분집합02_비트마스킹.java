package LiveClass.심화.비트연산자_부분집합;

public class 부분집합02_비트마스킹 {
    static String[] 재료 = {"단무지", "햄", "오이", "계란"};
    static int n = 4;
    static int[] sel = new int[n];

    public static void main(String[] args) {


        
        // 모든 김밥의 경우의 수
//        for (int i = 0; i < Math.pow(2, n); i++) {
//
//        }
        // 비트연산을 사용한 방법. 괄호로 감싸주어 가독성을 높이는걸 권장.
        for (int i = 0; i < (1 << n); i++) {
            System.out.print("김밥: ");
            // 재료를 체크한다.
            for (int j = 0; j < n; j++) {
                // 재료를 하나씩 쉬프트 하면서 검사할거다. 1인지를 확인하면 안됨. 0이 아니거나, 0보다 클때로 검사해야한다.
                if ((i & (1 << j)) != 0) {

                    System.out.print(재료[j]);

                }
            }
            System.out.println();
        }
    }
}
