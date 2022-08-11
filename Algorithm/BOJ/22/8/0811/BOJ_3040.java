package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] dwarps = new int[9];
	static boolean[] sel = new boolean[9];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			dwarps[i] = Integer.parseInt(br.readLine());
		}
		comb(0, 0);
	}
	public static void comb(int idx, int cnt) {
		if (cnt == 7) {
			int count = 0; 
			for (int i = 0; i < 9; i++) {
				if (sel[i]) {
					count += dwarps[i];
				}
			}
			if (count == 100) {
				for (int i = 0; i < 9; i++) {
					if (sel[i]) {
						System.out.println(dwarps[i]);
					}
				}
			}
			return;
		}
		if (idx == 9) {
			return;
		}
		sel[idx] = true;
		comb(idx+1, cnt+1);
		sel[idx] = false;
		comb(idx+1, cnt);
	}
}