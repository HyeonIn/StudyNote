package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, M;
	static int[] nums;
	static boolean[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N+1];
		String temp[] = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(temp[i-1]);
		}
		
		dp = new boolean[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			dp[i][i] = true;
		}
		for (int i = 1; i <= N-1; i++) {
			if (nums[i] == nums[i+1]) {
				dp[i][i+1] = true;
			}
		}
		for (int i = 3; i <= N; i++) {
			for (int j = 1; j <= N+1-i; j++) {
				if (nums[j] == nums[j+i-1]) {
					if (dp[j+1][j+i-2]) {
						dp[j][j+i-1] = true;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			temp = br.readLine().split(" ");
			sb.append(dp[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] ? 1: 0).append('\n');
		}
		System.out.println(sb);
	}
}