import java.util.Arrays;

public class 패턴매칭01_KMP {

    public static void main(String[] args) {
        String text = "ABABABACABAABABACACA";
        String pattern = "ABABACA";

//        System.out.println(Arrays.toString(getPi(pattern)));

        KMP(text, pattern);
    } // main

    // t : 본문, p : 패턴
    public static void KMP(String t, String p) {
        // 실패함수가 필요해!
        int[] pi = getPi(p); // 점프테이블 준비!

        int j = 0; // 패턴의 인덱스
        for(int i = 0; i < t.length(); i++) {
            // 1. 다를 때
            while(j > 0 && t.charAt(i) != p.charAt(j)) {
                j = pi[j-1]; // 점프
            }

            // 2. 같을 때
            if(t.charAt(i) == p.charAt(j)) {
                if(j == p.length() - 1) {
                    System.out.println((i - p.length()+1) + "패턴 찾았다!");
                    j = pi[j];
                }else {
                    j++;
                }
            }
        } // 본문을 순회하는 반복문
    }

    // pi[] : 패턴 P를 i 인덱스 까지 잘라서 최대 접두사와 접미사가 일치하는 최디 길이를 저장하는 배열
    public static int[] getPi(String p) {
        int[] pi = new int[p.length()];

        int j = 0;
        // i : 0부터 i까지 부분문자열을 완성하겠다.
        for(int i = 1; i < p.length(); i++) {
            // i와 j가 가리키는 값이 다르다면..
            while(j > 0 && p.charAt(i) != p.charAt(j)) {
                j = pi[j-1];
            }
            // i와 j가 가리키는 값이 같다면..
            if(p.charAt(i) == p.charAt(j)) {
                pi[i] = ++j;
            }
        }

        return pi;
    }
}