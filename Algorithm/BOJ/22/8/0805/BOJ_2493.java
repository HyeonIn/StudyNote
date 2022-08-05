package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main { //출력 케이스가 50만개 여서 스트링빌더 꼭 써야 하는 문제 였음.... 그리고 HashMap에 getOrDefault 사용해야 contain 안쓰고 풀수있음	
	static class tower{
		int height;
		int idx;
		
		public tower(int height, int idx){
			this.height = height;
			this.idx = idx;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String[] arr = br.readLine().split(" ");
		int[] answer = new int[n];
		tower[] dp = new tower[n];
		dp[0] = new tower(Integer.parseInt(arr[0]), 1);
		Stack<tower> s = new Stack<>();
		
		for (int i = n-1; i > 0; i--) {
			int tempHeight = Integer.parseInt(arr[i]);
			int leftHeight = Integer.parseInt(arr[i-1]);
			if (tempHeight > leftHeight) {
				s.push(new tower(tempHeight, i));
			}
			else {
				answer[i] = i;
				
				while(!s.isEmpty()) {
					tower t = s.pop();
					if (t.height < leftHeight) {
						answer[t.idx] = i;
					}
					else {
						s.push(t);
						break;
					}
				}
			}
		}
		while(!s.isEmpty()) {
			tower t = s.pop();
			answer[t.idx] = 0;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(answer[i]).append(' ');
		}
		System.out.println(sb);
	}
}