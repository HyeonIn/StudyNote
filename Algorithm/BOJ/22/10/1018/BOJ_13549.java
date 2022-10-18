package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	int[] dp = new int[100001];
    	for (int i = 0; i < 100001; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
    	
    	int[] dx = {-1,1};
    	
    	ArrayDeque<Integer> q = new ArrayDeque<>();
    	
    	q.add(N);
    	dp[N] = 0;
    	while (!q.isEmpty()) {
			int temp = q.poll();
			for (int j = 0; j < 3; j++) {
				int nx;
				if (j == 2) {
					nx = temp * 2;
					if (nx < 0 || nx >= 100001) {
						continue;
					}
					if (dp[nx] > dp[temp]) {
						dp[nx] = dp[temp];
						q.add(nx);
					}
				}
				else {
					nx = temp + dx[j];
					if (nx < 0 || nx >= 100001) {
						continue;
					}
					if (dp[nx] > dp[temp]+1) {
						dp[nx] = dp[temp]+1;
						q.add(nx);
					}
				}
			}
		}
    	System.out.println(dp[K]);
    }
}