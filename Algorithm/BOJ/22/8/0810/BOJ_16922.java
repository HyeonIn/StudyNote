package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int count = 0;
	static boolean[] check = new boolean[1001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n-i; j++) {
				for (int k = 0; k <= n-i-j; k++) {
					int[] rom = {i, j, k, n-i-j-k};
					int temp = (1 * i) + (5 * j) + (10 * k) + (50 * (n-i-j-k));
					if (!check[temp]) {
						check[temp] = true;
						count++;
					}
				}
			}
		}
	
		System.out.println(count);
	}
}