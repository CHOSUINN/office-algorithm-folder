package SWTestA.TrialTwo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int[] arr;
	static int n;
	static int dayCnt;
	static int maxHeight;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("src/testA/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int tc = Integer.parseInt(st.nextToken());
		for (int t = 0; t < tc; t++) {
		
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			
			arr = new int[n];
			st = new StringTokenizer(br.readLine(), " ");
			maxHeight = 0;
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (arr[i] > maxHeight) {
					maxHeight = arr[i];
				}
			}
			
			// 최종 키에 도달했을대, flag = true 설정.
			flag = false;
			int answer = dfs(arr, maxHeight, false, 0);
			
//			Node node = new Node(arr, false, 0);
//			int answer = bfs(node);
			
			System.out.println(answer);
		}
	}
	
//	// evenOdd = true == 짝수 false == 홀수
	private static int dfs(int[] a, int maxHeight, boolean evenOdd, int dayCnt) {
		if (flag)
			return Integer.MAX_VALUE;
		
		// 종료조건
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == maxHeight)
				cnt++;
		}
		if (cnt == n) {
			flag = true;
			return dayCnt;
		}
		
		// 뿌 연산
		int[] b = ft_copyArray(a);
		for (int i = 0; i < n; i++) {
			if (b[i] == maxHeight) continue;
			if (evenOdd)
				b[i] += 2;
			else
				b[i] += 1;
			
			if (b[i] > maxHeight) 
				return Integer.MAX_VALUE;

		}
		int temp1 = dfs(b, maxHeight, !evenOdd, dayCnt + 1); // 뿌
		int temp2 = dfs(a, maxHeight, !evenOdd, dayCnt + 1); // 안뿌
		return Math.min(temp1, temp2);
		
	}
	
//	private static int bfs(Node node) {
//		Queue<Node> q = new ArrayDeque<>();
//		q.offer(node);
//		
//		while (!q.isEmpty()) {
//			Node temp = q.poll();
//			Node newNode = new Node(ft_copyArray(temp.arr), !temp.evenOdd, temp.dayCnt);
//
//			boolean flag = true;
//			// 뿌
//			for (int i = 0; i < n; i++) {
//				if (temp.evenOdd)
//					temp.arr[i] += 2;
//				else
//					temp.arr[i] += 1;
//				
//				if (temp.arr[i] > maxHeight)
//					flag = false;
//			}
//			temp.evenOdd = !temp.evenOdd;
//			temp.dayCnt += 1;
//			if (flag) {
//	
//				int cnt = 0;
//				for (int i = 0; i < n; i++)
//					if (temp.arr[i] == maxHeight)
//						cnt++;
//				if (cnt == n)
//					return dayCnt;
//				
//				q.offer(temp);
//			}
//			
//			// 안뿌
//			q.offer(newNode);
//			
//		}
//		return dayCnt;
//	}
//	
//	static class Node {
//		int[] arr; 
//		boolean evenOdd;
//		int dayCnt;
//		
//		public Node(int[] a, boolean evenOdd, int dayCnt) {
//			arr = ft_copyArray(a);
//			this.evenOdd = evenOdd;
//			this.dayCnt = dayCnt;
//		}
//	}
	
	
	private static int[] ft_copyArray(int[] a) {
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = a[i];
		}
		return b;
	}

}
