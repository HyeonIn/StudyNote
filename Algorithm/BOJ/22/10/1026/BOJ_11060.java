import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, target;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위한 버퍼리더
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		int dp[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			if (dp[i] == Integer.MAX_VALUE) {
				break;
			}
			for (int j = 0; j < arr[i]; j++) {
				int ni = i+j+1;
				if (ni >= N) {
					break;
				}
				dp[ni] = Integer.min(dp[i] + 1, dp[ni]);
			}
		}
		System.out.println(dp[N-1]==Integer.MAX_VALUE ? -1 : dp[N-1]);
	}
}
