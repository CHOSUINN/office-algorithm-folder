package SWTestA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
	int studentNum;
	List<Integer> left = new ArrayList<>();
	List<Integer> right = new ArrayList<>();
	
	public Node(int studentNum) {
		this.studentNum = studentNum;
	}
	
	public void connectLeft(int studentNum) {
		left.add(studentNum);
	}
	
	public void connectRight (int studentNum) {
		right.add(studentNum);
	}
}

// 키 순서
// 노드를 만들어서 서로 연결해. 각 노드를 돌면서 자기 왼쪽 오른쪽 값을 탐색하고 해당 값이 n-1이면 자기 위치를 아는 놈. 이 아는 놈 갯수를 세면 정답.
public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = Integer.parseInt(sc.nextLine());
		
		for (int t = 0; t < tc; t++) {
			int answer = 0;
			
			int n = Integer.parseInt(sc.nextLine());
			int m = Integer.parseInt(sc.nextLine());
			
			Node[] arr = new Node[n + 1];
			
			for (int i = 0; i < m; i++) {
				String[] input = sc.nextLine().split(" ");
				int a = Integer.parseInt(input[0]);
				int b = Integer.parseInt(input[1]);
				
				arr[a].connectRight(arr[b].studentNum);
				arr[b].connectLeft(arr[a].studentNum);
				
			}
			
			
			// 각 노드의 좌우를 탐색하면서 총 개수를 세.
			// 총 개수가 n-1이면 answer++;
			for (int i = 1; i < n + 1; i++) {
				int cnt = 0;
				
			}
			
			
			System.out.printf("#%d %d", t + 1, answer);
			
	
			
			
			
			
		}
		
		
		
	}

}
