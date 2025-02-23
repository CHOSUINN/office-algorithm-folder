package BOJ;

import java.util.Scanner;
import java.util.StringTokenizer;

// 너의 평점은
public class BOJ25206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        double answer = 0.0;   // (학점 * 과목평점)의 합
        double gradeScoreTotal = 0.0; // 학점의 총합
        for (int t = 0; t < 20; t++) {
            st = new StringTokenizer(sc.nextLine());

            String subject = st.nextToken();
            double gradeScore = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.equals("P")) continue;

            double subjectAvg;
            if (grade.equals("A+"))
                subjectAvg = 4.5;
            else if (grade.equals("A0"))
                subjectAvg = 4.0;
            else if (grade.equals("B+"))
                subjectAvg = 3.5;
            else if (grade.equals("B0"))
                subjectAvg = 3.0;
            else if (grade.equals("C+"))
                subjectAvg = 2.5;
            else if (grade.equals("C0"))
                subjectAvg = 2.0;
            else if (grade.equals("D+"))
                subjectAvg = 1.5;
            else if (grade.equals("D0"))
                subjectAvg = 1.0;
            else
                subjectAvg = 0.0;

            answer += (gradeScore * subjectAvg);

            gradeScoreTotal += gradeScore;

        }
        System.out.printf("%.6f",answer / gradeScoreTotal);
    }
}
