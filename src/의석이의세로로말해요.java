import java.util.Scanner;

public class 의석이의세로로말해요 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < tc; t++) {
            char[][] arr = new char[5][15];

            for (int i = 0; i < 5; i++) {
                char[] inputs = sc.nextLine().toCharArray();
                for (int j = 0; j < inputs.length; j++) {
                    arr[i][j] = inputs[j];
                }
            }

            sb.append("#");
            sb.append(t + 1);
            sb.append(" ");
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 5; j++) {
                    if (arr[j][i] != '\0') {
                        sb.append(arr[j][i]);
                    }
                }
            }

            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
