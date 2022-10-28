package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위한 버퍼리더
		
		int N = Integer.parseInt(br.readLine()); 
		
		long[] dp = new long[10001];
		dp[0] = 1;
		dp[2] = 1;
		dp[4] = 2;
		
		for (int i = 6; i <= 10000; i+=2) {
			for (int j = 0; j <= i-2; j+=2) {
				dp[i] += ((dp[j]%987654321)* (dp[i-2-j] % 987654321))%987654321; 
			}
		}
		dp[0] = 0;
		System.out.println(dp[N]%987654321);
	}
}
