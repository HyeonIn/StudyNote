package swea;

import java.io.BufferedReader;
import java.io.IOException;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int check = 0;
			int N = Integer.parseInt(br.readLine());
			int mul = 1;
			while (check != 1023) {
				char[] arr = String.valueOf(N * mul++).toCharArray();
				for (char c : arr) {
					int num = c - '0';					
					check = check | (1 << num);
				}
			}
			System.out.printf("#%d %d\n", t+1, N * (mul-1));
		}
	}
}
