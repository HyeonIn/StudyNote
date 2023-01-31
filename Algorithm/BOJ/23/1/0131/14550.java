package boj;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int[] board;
		int[][] dp;
		while (true) {
			int N = sc.nextInt();
			if (N == 0) {
				break;
			}
			int S = sc.nextInt();
			int T = sc.nextInt();
			
			board = new int[N+1];
			
			for (int i = 0; i < N; i++) {
				board[i] = sc.nextInt();
			}
			
			dp = new int[T][N+1];
			for (int i = 0; i < T; i++) {
				for (int j = 0; j < N+1; j++) {
					dp[i][j] = -20000000;
				}
			}
			for (int i = 0; i < S; i++) {
				dp[0][i] = board[i];
			}
			
			for (int i = 1; i < T; i++) {
				for (int j = i; j < N+1; j++) {
					for (int k = 1; k <= S; k++) {
						if (j-k >=0 ) {
							dp[i][j] = Math.max(dp[i][j], dp[i-1][j-k] + board[j]);
						}
					}
				}
			}
			int answer = dp[0][N];
			for (int i = 1; i < T; i++) {
				answer = Math.max(answer, dp[i][N]);
			}
			System.out.println(answer);
		}		
	}
}
