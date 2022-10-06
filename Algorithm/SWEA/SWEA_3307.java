package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] dp = new int[N];
			int[] arr = new int[N];
			
			String[] temp = br.readLine().split(" ");
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(temp[i]);
			}
			
			dp[0] = 1;
			
			int answer = 1;
			for (int i = 1; i < N; i++) {
				int max = 1;
				for (int j = 0; j < i; j++) {
					if (arr[j] < arr[i]) {
						max = Math.max(max, dp[j]+1);						
					}
				}
				dp[i] = max;
				answer = Math.max(dp[i], answer);
			}
			System.out.printf("#%d %d\n", t, answer);
		}
	}
}