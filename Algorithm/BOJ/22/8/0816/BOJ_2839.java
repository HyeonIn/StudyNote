package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int answer = Integer.MAX_VALUE;
		int[] dp = new int[n/3+1];
		
		for (int i = 0; i <= n/3; i++) {
			if ((n - (3*i)) % 5 != 0 ) {
				dp[i] = -1;
			}
			else {
				dp[i] = ((n - (3*i)) / 5) + i;
			}
		}
		
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] != -1) {
				answer = Math.min(answer, dp[i]);
			}
		}
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
}