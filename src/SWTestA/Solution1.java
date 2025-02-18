package SWTestA;

import java.util.Scanner;

// 화분
public class Solution1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = Integer.parseInt(sc.nextLine());
		
		for (int t = 0; t < tc; t++) {
			
			String[] input = sc.nextLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int p = Integer.parseInt(input[1]);
			
			int[] arr1 = new int[n];
			int[] arr2 = new int[n];
			String[] input1 = sc.nextLine().split(" ");
			String[] input2 = sc.nextLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr1[i] = Integer.parseInt(input1[i]);
				arr2[i] = Integer.parseInt(input2[i]);
			}

			
			// 1번 비료부터 주고 시작했을때 계산.
			int answer1 = 0;
			answer1 = arr1[0];
			int flag = 1; // 방금 사용한 비료
			int same = 0;
			for (int i = 1; i < n; i++) {
				int num1 = 0;
				int num2 = 0;
				
				if (flag == 1) {
					num1 = arr1[i] - p;
					if (num1 < 0)
						num1 = 0;
				} else {
					num1 = arr1[i];
				}
				
				if (flag == 2) {
					num2 = arr2[i] - p;
					if (num2 < 0)
						num2 = 0;
				} else {
					num2 = arr2[i];
				}
				
				// 책임 전가 당했을때,
				if (flag > 2) {
					
					// 이전 값이 1비료 사용하고 전가 당했을대,
					if (flag%5 == 1) {
						num1 = arr1[i] - p;
						if (num1 < 0)
							num1 = 0;
						num1 = num1 + same;
						same = 0;
					} else {
						num1 = arr1[i] + same;
						same = 0;
					}
					
					// 이전 값이 2비료 사용하고 전가 당햇을때,
					if (flag%5 == 2) {
						num2 = arr2[i] - p;
						if (num2 < 0)
							num2 = 0;
						num2 = num2 + same;
						same = 0;
					} else {
						num2 = arr2[i] + same;
						same = 0;
					}
				}
				
				
				flag = ft_findMax(num1, num2, flag);
				
				// 비교 값이 같으면, 이전 flag 값  + 5일때
				if (flag > 2) {
					
					// 비교 값이 같더라도 만약 해당 인덱스가 마지막 값 비교이면, 다음 인덱스로 책임을 전가하지 않고 바로 계산
					if (i == n - 1) {
						answer1 += Math.max(num1, num2);
						same = 0;
					} else {
						same = Math.max(num1,  num2);
					}
					
				} else {
					answer1 += Math.max(num1,  num2);
				}
			}
			
			// 2번 비료부터 주고 시작했을때 계산.
			int answer2 = 0;
			answer2 = arr2[0];
			flag = 2;
			same = 0; // 만약 현재 비교값이 동일할때, flag= 이전 값  + 5를 넣어주고 다음 값이 값을지를 확인. 
			for (int i = 1; i < n; i++) {
				int num1 = 0;
				int num2 = 0;
				
				// 이전 값이 1일때.
				if (flag == 1) {
					num1 = arr1[i] - p;
					if (num1 < 0)
						num1 = 0;
				} else {
					num1 = arr1[i];
				}
				
				// 이전 값이 2일때,
				if (flag == 2) {
					num2 = arr2[i] - p;
					if (num2 < 0)
						num2 = 0;
				} else {
					num2 = arr2[i];
				}
				
				// 책임 전가 당했을때,
				if (flag > 2) {
					
					// 이전 값이 1비료 사용하고 전가 당했을대,
					if (flag%5 == 1) {
						num1 = arr1[i] - p;
						if (num1 < 0)
							num1 = 0;
						num1 = num1 + same;
						same = 0;
					} else {
						num1 = arr1[i] + same;
						same = 0;
					}
					
					// 이전 값이 2비료 사용하고 전가 당햇을때,
					if (flag%5 == 2) {
						num2 = arr2[i] - p;
						if (num2 < 0)
							num2 = 0;
						num2 = num2 + same;
						same = 0;
					} else {
						num2 = arr2[i] + same;
						same = 0;
					}
				}
				
				
				flag = ft_findMax(num1, num2, flag);
				
				// 비교 값이 같으면, 이전 flag 값  + 5일때
				if (flag > 2) {
					
					// 비교 값이 같더라도 만약 해당 인덱스가 마지막 값 비교이면, 다음 인덱스로 책임을 전가하지 않고 바로 계산
					if (i == n - 1) {
						answer2 += Math.max(num1, num2);
						same = 0;
					} else {
						same = Math.max(num1,  num2);
					}
					
				} else {
					answer2 += Math.max(num1,  num2);
				}
				
			}
			
			int answer = Math.max(answer1,  answer2);
			
			System.out.printf("#%d %d\n", t + 1, answer);
			
			
			
			
		}
		
		
		
	}
	
	// num1 == 1번 비료, num2 == 2번 비료
	// 더 큰 비료 값 반환
	// 만약 두 비교 값이 같다면 flag + 5로 반환
	private static int ft_findMax(int num1, int num2, int flag) {
		if (num1 > num2)
			return 1;
		else if (num1 < num2)
			return 2;
		else
			return flag + 5;
	}
}
