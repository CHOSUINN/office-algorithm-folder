package SWTestA.TrialTwo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/testA/test2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int tc = Integer.parseInt(st.nextToken());
		for (int t = 0; t < tc; t++) {
		
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			
		
			
			
		}
	}

}
