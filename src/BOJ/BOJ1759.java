package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 암호 만들기

/**
 * 모음 자음으로 나눠서 모음의 개수 충족 후 자음 뽑기.
 */
public class BOJ1759 {
    static char[] arr;
    static char[] sel;
    static int l;
    static int c;
    static StringBuilder sb;
    static Set<Character> moeum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[c];
        sel = new char[l];
        moeum = new HashSet<>();

        moeum.add('a');
        moeum.add('e');
        moeum.add('i');
        moeum.add('o');
        moeum.add('u');

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        findComb(0, 0, 0, 0);
        System.out.println(sb);
    }

    private static void findComb(int idx, int arrIdx, int mo, int ja) {

        // 최소 두개 자음이 안될 때.
        if (l - 2 < mo) return;

        if (idx == l) {
            // sel 배열을 다 채웠을때.
            if (mo != 0)
                sb.append(sel).append("\n");
            return;
        }

        // arr 배열의 끝에 도달했을때.
        if (arrIdx == c) return;

        boolean flag = false;
        if (moeum.contains(arr[arrIdx])) {
            mo += 1;
            flag = true;
        } else
            ja += 1;

        sel[idx] = arr[arrIdx];

        findComb(idx + 1, arrIdx + 1, mo, ja);

        if (flag)
             mo -= 1;
        else
             ja -= 1;

        findComb(idx, arrIdx + 1, mo, ja);
    }
}
