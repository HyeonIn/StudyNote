import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위한 버퍼리더
		
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < 1001; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
		System.out.println(dp[N]);
	}
}