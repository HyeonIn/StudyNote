//18353 병사 배치하기
//최장 길이 수열을 dp로 기록하면서 이어질 수 있도록 만들어 주었다.
//dp에서 가장 큰 값이 가장 길게 병사를 배치한 경우이고 해당 경우를 전체 병사 수에서 빼주면 답이된다.

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] arr =new int[N];
		int[] dp = new int[N];
		
		String[] temp= br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(temp[i]);
			dp[i] = 1;
		}
		for (int i = 1; i < N; i++) {
			for (int j = i-1; j >= 0; j--) {
				if (arr[j] > arr[i]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			max = Math.max(dp[i], max);
		} 
		System.out.print(N-max);
	}
}