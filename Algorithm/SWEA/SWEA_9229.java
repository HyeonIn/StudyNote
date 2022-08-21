package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int TC, n, m;
	static int[] cookies;
	static boolean[] used;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
  
		for (int t = 1; t <= TC; t++) {
			String[] temp = br.readLine().split(" ");
			
			n = Integer.parseInt(temp[0]);
			m = Integer.parseInt(temp[1]);
			
			answer = -1;
			cookies = new int[n];
			used = new boolean[n];
			temp = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				cookies[i] = Integer.parseInt(temp[i]);
			}
			comb(0,0);
			
			System.out.printf("#%d %d\n", t,answer);
		}
		
	}
	static void comb(int idx, int cnt) {
		if (cnt == 2) {
			int weight = 0;
			for (int i = 0; i < n; i++) {
				if (used[i]) {
					weight += cookies[i];
				}
			}
			if (weight <= m && weight > answer) {
				answer = weight;
			}
			return;
		}
		if (idx == n) {
			return;
		}
		used[idx] = true;
		comb(idx+1, cnt+1);
		used[idx] = false;
		comb(idx+1, cnt);
	}
}