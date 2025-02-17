import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// 수영장
public class SWEA1952 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();


        int tc = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < tc; t++) {
            sb.append("#").append(t + 1).append(" ");
            String[] input = sc.nextLine().split(" ");
            int[] price = new int[4];
            price[0] = Integer.parseInt(input[0]); // dayPrice
            price[1] = Integer.parseInt(input[1]); // monthPrice
            price[2] = Integer.parseInt(input[2]); // threeMonthPrice
            price[3] = Integer.parseInt(input[3]); // annualPrice

            int[] plan = new int[12];
                String[] inputs = sc.nextLine().split(" ");
            for (int i = 0; i < 12; i++) {
                plan[i] = Integer.parseInt(inputs[i]);
            }

            List<Integer> continuousMonth = new ArrayList<>();
            int cnt = 0;
            int continuousMonthCnt = 1;

            if (plan[0] != 0)
                cnt += plan[0];
            for (int i = 1; i < 12; i++) {
                if (plan[i] != 0 && plan[i - 1] != 0) {
                    continuousMonthCnt += 1;
                } else {
                    continuousMonth.add(continuousMonthCnt);
                    continuousMonthCnt = 0;
                }
                cnt += plan[i];
            }

            int answer = 0;
            // 일일이용권 비용
            int dayPrice = price[0] * cnt;

            // 모두 1달 이용권
            int monthPrice = 0;
            int count = 0;
            for (int i = 0; i < 12; i++)
                if (plan[i] != 0)
                    count++;
            monthPrice = count * plan[1];

            // 1년 가격
            int annualPrice = plan[3];

            // 월 일 둘다 사용
            // 만약 3개월이 월보다 비싸면
            if (plan[2] >= plan[1]) {
                answer = Math.min(dayPrice, Math.min(monthPrice, annualPrice));
            }


            sb.append(answer);
            System.out.println(sb);
            sb.setLength(0);

        }

    }
}
