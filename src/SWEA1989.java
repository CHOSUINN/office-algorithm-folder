import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 초심자의 회문 검사
public class SWEA1989 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            
            // 입력받은 문자열 char배열로 변환
            char[] input = (br.readLine()).toCharArray();
            
            int answer = 1;
            for (int j = 0; j < input.length / 2; j++) {
                // 회문이 아닐경우 표시
                if (input[j] != input[input.length - 1 - j]) {
                    answer = 0;
                }
            }
            System.out.printf("#%d %d\n", i + 1, answer);

        }

    }
}
