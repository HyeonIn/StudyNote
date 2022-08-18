package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int[][] S;
	static boolean[] select;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		S = new int[n][n];
		select = new boolean[n];
		String[] temp;
		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				S[i][j] = Integer.parseInt(temp[j]);
			}
		}
		comb(0, 0);
		System.out.println(answer);
	}
	public static void comb(int idx, int cnt) {
		if(cnt == n/2) {
			int teamA = 0;
			int teamB = 0;
			for (int i = 0; i < n; i++) {
				if (select[i]) {
					for (int j = 0; j < n; j++) {
						if (select[j]) teamA += S[i][j];
					}
				}
				else {
					for (int j = 0; j < n; j++) {
						if (!select[j]) teamB += S[i][j];
					}
				}
			}
			answer = Math.min(Math.abs(teamA - teamB), answer);
			return;
		}
		if (idx == n) {
			return;
		}
		select[idx] = true;
		comb(idx+1, cnt+1);
		select[idx] = false;
		comb(idx+1, cnt);
	}
}