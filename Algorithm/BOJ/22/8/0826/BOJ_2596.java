package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static int N;
	static String[] alpha = {"000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"};
	static class coord{
		int i, j;
		public coord(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String msg = br.readLine();
		StringBuilder sb = new StringBuilder();
		boolean err = false;
		for (int i = 0; i < N; i++) {
			String temp = msg.substring(i*6, i*6+6);
			boolean find = false;
			for (int k = 0; k < 8; k++) {
				if (compare(temp, alpha[k])) {
					find = true;
					sb.append((char)(k+'A'));
				}
			}
			if (!find) {
				System.out.println(i+1);
				err = true;
				break;
			}
			
		}
		if (!err) {
			System.out.println(sb);
		}
	}
	public static boolean compare(String s1, String s2) {
		int cnt = 0;
		for (int i = 0; i < 6; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				cnt++;
			}
		}
		if (cnt >= 2) {
			return false;
		}
		else {
			return true;
		}
	}
}