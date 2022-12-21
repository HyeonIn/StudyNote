package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[501];
		int[] dp = new int[501];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st= new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 0) {
				dp[i] = dp[i-1];
				continue;
			}
			int count = 0;
			for (int j = i-1; j < i; j++) {
				if (arr[j] > arr[i]) {
					count+=1;
				}
			}
			if (count == 0) {
				answer += dp[i-1];
				dp[i] = 0;
			}
			else {
				dp[i] = Integer.max(dp[i-1], count);				
			}
		}
		answer += dp[500];
		System.out.println(answer);
	}
}