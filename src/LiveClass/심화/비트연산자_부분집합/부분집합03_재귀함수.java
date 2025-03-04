package LiveClass.심화.비트연산자_부분집합;

public class 부분집합03_재귀함수 {
    static String[] 재료 = {"단무지", "햄", "오이", "계란"};
    static int n = 4;
    static boolean[] sel = new boolean[n];
    
    public static void main(String[] args) {

        powerset(0
        );
    }

    // n은 static으로 선언
    // idx : 이번에 판단할 재료! (넣을지 말지)
    public static void powerset (int idx) {
        // 종료조건 (재료를 전부 고려했을때)
        if (idx == n) {
            // 출력을 위한 코드
//            String temp = "김밥: " ;
//            for (int i = 0; i < n; i++) {
//                if (sel[i]) {
//                    temp += 재료[i];
//                }
//            }
//            System.out.println(temp);
            return;
        }

        // 재귀부분
        sel[idx] = false; // idx 자리의 재료를 넣지 않겠다.
        powerset(idx + 1);  // 다음 재료로 이동

        sel[idx] = true; // idx 자리의 재료를 넣겠다.
        powerset(idx + 1); // 다음 재료로 이동
    }

}
