// dp의 점화식을 세워 보면
// di 는 i 번째 까지 계단 점수합의 최대 값
// d1 = n1; d2 = n1+n2, d3 = max(n1+n3, n2+n3), d4 부터는 di = max(d(i-3) + n(i-1) + ni, d(i-2) + ni) 로 세워진다
// 세워진 점화식에 맞게 구현하면 끝

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} 
		if (N==1) {
			System.out.println(arr[0]);
		}
		else if (N==2) {
			System.out.println(arr[0]+arr[1]);
		}
		else {
			dp[0] = arr[0];
			dp[1] = arr[1] + arr[0];
			dp[2] = Math.max(arr[0]+arr[2], arr[1]+arr[2]);
			for (int i = 3; i < N; i++) {
				dp[i] = Math.max(dp[i-3] + arr[i-1]+arr[i], dp[i-2]+arr[i]);
			}			
			System.out.println(dp[N-1]);
		}
		
	}
}