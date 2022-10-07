package boj;

// 2624 동전바꿔주기
// dp로 접근하기 위해 동전을 작은 순서로 정렬해주었다
// 우선 한 종류의 동전으로 만들 수 있는 경우로 dp를 초기화 해준다
// 현재 동전보다 작은 동전에다가 현재 동전을 더해서 만들 수 있는 경우를 dp로 기록해 나간다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int answer;
    static class coin implements Comparable<coin>{
    	int p, n;

		public coin(int p, int n) {
			this.p = p;
			this.n = n;
		}

		@Override
		public int compareTo(coin o) {
			return this.p-o.p;
		}
    	
    }
    public static void main(String[] args) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	int K = Integer.parseInt(br.readLine());
    	
    	ArrayList<coin> coins = new ArrayList<>();
    	
    	for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			coins.add(new coin(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
    	Collections.sort(coins);
    	int[][] dp = new int[K][T+1];
    	
    	for (int i = 0; i < K; i++) {
			for (int j = 1; j <= coins.get(i).n; j++) {
				if (coins.get(i).p * j > T) {
					break;
				}
				dp[i][coins.get(i).p*j] = 1;
			}
		}

    	for (int i = 1; i < K; i++) {
			for (int j = 1; j <= T; j++) {
				dp[i][j] += dp[i-1][j];
				for (int k = 1; k <= coins.get(i).n; k++) {
					int prev = j-coins.get(i).p*k;
					if (prev < 0) {
						continue;
					}
					dp[i][j] += dp[i-1][prev];
				}
			}
		}
    	
    	System.out.println(dp[K-1][T]);

    }
    
}