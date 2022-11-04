package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if (arr[i] < arr[j]) {
					dp[j] = Math.max(dp[i]+1, dp[j]);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}
}