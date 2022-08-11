package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		BigInteger[][] map = new BigInteger[102][102];
		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {
				map[i][j] = new BigInteger("0");
			}
		}
		map[1][1] = new BigInteger("1");
		for (int i = 2; i <= 101; i++) {
			for (int j = 1; j <= i; j++) {
				map[i][j] = map[i-1][j-1].add(map[i-1][j]);
			}
		}
		System.out.println(map[n+1][m+1]);
	}
}