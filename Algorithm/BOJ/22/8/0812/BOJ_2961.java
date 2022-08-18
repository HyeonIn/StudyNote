package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	
	static class taste{
		int s;
		int b;
		public taste(int s, int b) {
			this.s = s;
			this.b = b;
		}
	}
	static taste[] T;
	static boolean[] select;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		T = new taste[n];
		select = new boolean[n];
		String[] temp;
		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			T[i] = new taste(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
		}
		
		powerset(0);
		
		System.out.println(answer);
	}
	public static void powerset(int idx) {
		if(idx == n) {
			int tempS = 1;
			int tempB = 0;
			for (int i = 0; i < n; i++) {
				if (select[i]) {
					tempS *= T[i].s;
					tempB += T[i].b;
				}
			}
			if (tempB != 0) {
				answer = Math.min(Math.abs(tempS-tempB), answer);
			}
			return;
		}
		select[idx] = true;
		powerset(idx+1);
		select[idx] = false;
		powerset(idx+1);
	}
}