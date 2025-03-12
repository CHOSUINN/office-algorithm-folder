package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 영재의 시험
public class BOJ19949 {

    static final int EXAM_QUESTIONS = 10;
    static final int EXAM_ANSWER_NUMBER = 5;

    static int[] answerSheet;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        answer = 0;
        answerSheet = new int[EXAM_QUESTIONS];
        for (int i = 0; i < EXAM_QUESTIONS; i++)
            answerSheet[i] = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= EXAM_ANSWER_NUMBER; i++) {
            int score = 0;
            if (i == answerSheet[0])
                score = 1;
            f(0, i, score, 1);
        }


        System.out.println(answer);
    }

    // last question answer
    // this question answer
    // score는 현재 점수
    // idx는 answerSheet의 답을 확인할 인덱스
    private static void f(int lqa, int tqa, int score, int idx) {

        if (idx == EXAM_QUESTIONS) {
            if (score >= 5) {
                answer++;
            }
            return;
        }

        for (int i = 1; i <= EXAM_ANSWER_NUMBER; i++) {
            if (lqa == i && tqa == i) continue;

            int nextScore = score;
            if (i == answerSheet[idx])
                nextScore += 1;
            f(tqa, i, nextScore, idx + 1);
        }
    }
}
